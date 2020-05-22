package com.test.inspector;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringTokenizer;

public class SearchFile {
    private static String dir = "/Users/swapnil.kotwal/Swapnil/myproject/build/WEB-INF/classes/test/";

    private static String csvConnClasses = dir + "FirstTest*.class,"+ dir+"SecondTest.class,"+dir+"abcd/";

    public static class SearchFileVisitor extends SimpleFileVisitor<Path> {

        private final PathMatcher pathMatcher;
        private int matchCount = 0;

        SearchFileVisitor(String globPattern) {
            pathMatcher = FileSystems.getDefault().getPathMatcher(
                    "glob:" + globPattern);
        }

        @Override
        public FileVisitResult visitFile(Path filePath,
                BasicFileAttributes basicFileAttrib) {
            if (pathMatcher.matches(filePath.getFileName())) {
                matchCount++;
                System.out.println(filePath);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path directoryPath,
                BasicFileAttributes basicFileAttrib) {
            if (pathMatcher.matches(directoryPath.getFileName())) {
                matchCount++;
                System.out.println(directoryPath);
            }
            return FileVisitResult.CONTINUE;
        }

        public int getMatchCount() {
            return matchCount;
        }
    }

    public static void main(String[] args) throws IOException {
        if (null != csvConnClasses) {
            StringTokenizer st = new StringTokenizer(csvConnClasses, ",");
            while (st.hasMoreTokens()) {
                String cls = st.nextToken();
                // Removes all whitespaces and non-visible characters like tab,
                // \n etc.
                cls = cls.replaceAll("\\s+", "");
                Path rootPath = FileSystems.getDefault().getPath( cls.substring(0, cls.lastIndexOf("/")) );
        String globPattern = (new File(cls)).getName();

        SearchFileVisitor searchFileVisitor = new SearchFileVisitor(globPattern);
        Files.walkFileTree(rootPath, searchFileVisitor);
        System.out.println("Match Count: " + searchFileVisitor.getMatchCount());
       }
    }
  }
}