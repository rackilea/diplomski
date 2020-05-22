2943    public static void moveFile(final File srcFile, final File destFile) throws IOException {
2944        if (srcFile == null) {
2945            throw new NullPointerException("Source must not be null");
2946        }
2947        if (destFile == null) {
2948            throw new NullPointerException("Destination must not be null");
2949        }
2950        if (!srcFile.exists()) {
2951            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
2952        }
2953        if (srcFile.isDirectory()) {
2954            throw new IOException("Source '" + srcFile + "' is a directory");
2955        }
2956        if (destFile.exists()) {
2957            throw new FileExistsException("Destination '" + destFile + "' already exists");
2958        }
2959        if (destFile.isDirectory()) {
2960            throw new IOException("Destination '" + destFile + "' is a directory");
2961        }
2962        final boolean rename = srcFile.renameTo(destFile);
2963        if (!rename) {
2964            copyFile( srcFile, destFile );
2965            if (!srcFile.delete()) {
2966                FileUtils.deleteQuietly(destFile);
2967                throw new IOException("Failed to delete original file '" + srcFile +
2968                        "' after copy to '" + destFile + "'");
2969            }
2970        }
2971    }