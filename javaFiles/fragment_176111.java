for (int u = 0; u < row && fileReader.hasNextLine(); u++) {

        String line = fileReader.nextLine();

        for (int i = 0; i < col; i++) {

            pic[u][i] = line.charAt(offset++);
        }

        offset = 0;
    }
    return pic;