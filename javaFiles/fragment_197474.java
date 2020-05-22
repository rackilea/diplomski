byte[] input = new byte[4096];

    int bytesRead;
     while ((bytesRead = inFile.read(input, 0, 4096)) != -1)
                {
                  byte[] output = cipher.update(input, 0, bytesRead);
                   if (output != null) outFile.write(output);
               }