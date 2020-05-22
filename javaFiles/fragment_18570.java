package com.stackoverflow.Q12082277.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author maba, 2012-08-24
 *
 * @goal extract
 */
public class PropertiesMojo extends AbstractMojo {

    private Log log;

    /**
     * The current project representation.
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * A properties file
     *
     * @parameter expression="${propertiesFile}"
     * @required
     */
    private File propertiesFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("Executing PropertiesMojo on " + propertiesFile.getAbsolutePath());

        try {
            Properties fileProperties = new Properties();
            fileProperties.load(new FileInputStream(propertiesFile));
            Properties projectProperties = project.getProperties();
            for (Object key : fileProperties.keySet()) {
                projectProperties.setProperty((String)key, (String) fileProperties.get(key));
            }
            project.getProperties().list(System.out);
        } catch (FileNotFoundException e) {
            throw new MojoFailureException("The file " + propertiesFile.getAbsolutePath() + " was not found!", e);
        } catch (IOException e) {
            log.error("");
        }

    }

    @Override
    public void setLog(Log log) {
        this.log = log;
    }
}