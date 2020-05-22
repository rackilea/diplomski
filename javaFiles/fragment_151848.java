FileVisitResult walk(File file, FileVisitor<File> visitor)
    throws IOException
{
    if (file.isDirectory()) {
        visitor.preVisitDirectory(file, null);
        for (File child : file.listFiles()) {
            walk(child, visitor);
        }
        return visitor.postVisitDirectory(file, null);
    } else {
        return visitor.visitFile(file, null);
    }
}