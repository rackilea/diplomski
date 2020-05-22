package com.example;

import org.apache.commons.io.IOUtils;

import java.util.Arrays;

public class SubProcess {
    private final Class<?> classToRun;

    public SubProcess(Class<?> classToRun) {
        this.classToRun = classToRun;
    }

    public String run(String... args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("java",
                "-Djava.library.path=" + System.getProperty("java.library.path"),
                "-classpath", System.getProperty("java.class.path"),
                classToRun.getCanonicalName());

        for (String arg : args) processBuilder.command().add(arg);

        processBuilder.redirectErrorStream();

        Process process = processBuilder.start();

        String output = IOUtils.toString(process.getInputStream());

        process.waitFor();

        if (process.exitValue() != 0)
            throw new IllegalStateException(
                    String.format("Running %s with %s failed", classToRun, Arrays.toString(args)));

        return output;
    }
}