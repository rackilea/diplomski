if (file.isFile()) {
  Charset charset = StandardCharsets.UTF_8;
  String content = new String(Files.readAllBytes(file.toPath()), charset);
  content = content.replaceAll("(?i)" + oldName, newName); // Modified here
  String newFileName = file.getAbsolutePath().replace(oldName, newName);
  File newFile = new File(newFileName);
  newFile.getParentFile().mkdirs();
  newFile.createNewFile();
  Files.write(newFile.toPath(), content.getBytes());
}