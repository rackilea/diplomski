package com.test.files;

import org.apache.log4j.Logger;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

import static java.nio.file.FileVisitResult.TERMINATE;


public class MoveFileVisitor implements FileVisitor<Path> {

    private static final Logger LOGGER = Logger.getLogger(MoveFileVisitor.class);
    private final Path target;
    private final Path source;

    public MoveFileVisitor(@NotNull Path source, @NotNull Path target) {
        this.target = Objects.requireNonNull(target);
        this.source = Objects.requireNonNull(source);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativePath = source.relativize(dir);
        Path finalPath = target.resolve(relativePath);
        Files.createDirectories(finalPath);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath = source.relativize(file);
        Path finalLocation = target.resolve(relativePath);
        Files.move(file, finalLocation);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        LOGGER.error("Failed to visit file during move" + file.toAbsolutePath(), exc);
        return TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }


}