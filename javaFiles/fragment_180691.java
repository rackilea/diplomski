public void writeFile(File aFile) throws FileNotFoundException, IOException {
        if (aFile == null) {
      throw new IllegalArgumentException("File should not be null.");
    }
    if (!aFile.exists()) {
      throw new FileNotFoundException ("File does not exist: " + aFile);
    }
    if (!aFile.isFile()) {
      throw new IllegalArgumentException("Should not be a directory: " + aFile);
    }
    if (!aFile.canWrite()) {
      throw new IllegalArgumentException("File cannot be written: " + aFile);
    }

    BufferedWriter output = new BufferedWriter(new FileWriter(aFile));
    try {
        for(int count = 0; count < numLines; count++) {
            output.write(lines[count]);
            if(count != numLines-1) {// This makes sure that an extra new line is not inserted at the end of the file
                output.newLine();
            }

        }

    }
    finally {
      output.close();
    }
    }