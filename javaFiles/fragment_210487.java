package com.kp.plugin.logcodegen;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "code-gen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class MyMojo extends AbstractMojo {

@Parameter(defaultValue = "${project.build.directory}")
private File outputDirectory;

@Parameter(defaultValue = "${basedir}")
private File baseDir;

@Parameter(defaultValue = "src/main/java", property = "sourceDirecory")
private String sourceDirectory;

@Parameter(defaultValue = "", property = "packageNames")
private String packageNames;

@Parameter(defaultValue = "", property = "addImport")
private String addImport;

@Parameter(defaultValue = "", property = "removeImport")
private String removeImport;

@Parameter(defaultValue = "", property = "defineLogInstance")
private String defineLogInstance;

@Parameter(defaultValue = "", property = "removeLogInstance")
private String removeLogInstance;

public void execute() throws MojoExecutionException {
    System.out.println("-------------------");
    System.out.println("Adding logs to java classes");
    System.out.println("--------------------");
    System.out.println("Input package is:" + packageNames);
    System.out.println("BaseDir is " + baseDir.getAbsolutePath());

    StringBuilder sourceDir = new StringBuilder(baseDir.getAbsolutePath());
    sourceDir.append("/");
    sourceDir.append(sourceDirectory);
    if (!packageNames.isEmpty()) {
        sourceDir.append("/");
        for (final String packageName : packageNames.split(",")) {
            String path = sourceDir.toString() + packageName.replaceAll("\\.", "/");
            File dest = new File(path);
            if (dest.isDirectory()) {
                Iterator<File> it = FileUtils.iterateFiles(dest, FileFileFilter.FILE, TrueFileFilter.INSTANCE);
                while (it.hasNext()) {
                    try {
                        processFile(it.next());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.append("Path is not directory " + path);
            }
        }
    } else {
        System.out.println("No packages to parse");
    }

}

private void processFile(final File file) throws IOException {
    List<String> contents = FileUtils.readLines(file);
    ListIterator<String> it = contents.listIterator();
    String className = "";
    while (it.hasNext()) {
        String str = it.next();
        // Remove import
        if (str != null && !str.isEmpty() && str.contains(removeImport)) {
            it.remove();
            it.add(addImport);
        }



        if (str != null && !str.isEmpty()) {
            Pattern pat = Pattern.compile("\\s*(public|private)\\s+class\\s+(\\w+)");
            Matcher matcher = pat.matcher(str);
            if (matcher.find()) {
                className = matcher.group(2);
            }
        }
        // change the instance
        if (str != null && !str.isEmpty() && str.contains(removeLogInstance)) {
            it.remove();
            it.add(defineLogInstance + className + ".class);");
        }
    }
    FileUtils.writeLines(file, contents, false);
}