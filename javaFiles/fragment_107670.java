void copyRecursively(Path sourceDir, Path destinationDir) {
    FileVisitor visitor =[
            preVisitDirectory : { Path filePath, BasicFileAttributes attrs ->
                Path newDirectory = destinationDir.resolve(sourceDir.relativize(filePath))
                Files.copy(filePath, newDirectory, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING)
                return FileVisitResult.CONTINUE
            },
            visitFile         : { Path filePath, BasicFileAttributes attrs ->
                Files.copy(filePath, destinationDir.resolve(sourceDir.relativize(filePath)), StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING)
                return FileVisitResult.CONTINUE
            },
            visitFileFailed   : { file, IOException ex -> return FileVisitResult.CONTINUE },
            postVisitDirectory: { dir, IOException ex -> return FileVisitResult.CONTINUE }
    ] as FileVisitor
    Files.walkFileTree(sourceDir, [FileVisitOption.FOLLOW_LINKS] as Set, Integer.MAX_VALUE, visitor)
}