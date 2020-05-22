try {
        FileWriter writer = new FileWriter(path);

        for (Movie movie : movies) {
            writer.write(movie.toString() + LINE_SEPARATOR);
        }

        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }