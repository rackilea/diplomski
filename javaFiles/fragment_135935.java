private static void writeToFile(String filePath, String fileName,
                                String fileData) throws IOException {
  FileWriter writer = new FileWriter(fileName);
  try {    
    writer.write(fileData);
  } finally {
    writer.close();
  }
}