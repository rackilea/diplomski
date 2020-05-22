File folder = new File("/Users/DAndre/Desktop/Alice");

    for (final File fileEntry : folder.listFiles()) {
        String fileName = fileEntry.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = br.readLine();
            }


            /**
             * Pass original file content as string to another method which
             * creates new file with same content.
             */
            newFile(stringBuilder.toString());
        } finally {
            br.close();
        }
    }