String subPath = sourceFile.getAbsolutePath().substring(sourceRoot.length);
File targetFile = new File(targetRoot + File.separator + subPath);

if (targetFile.getParentFile().exists()) {
  targetFile.getParentFile().mkdirs();
}
// copy, etc