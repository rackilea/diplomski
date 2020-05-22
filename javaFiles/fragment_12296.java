public static void Save(File file, String[][] list) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < list.length; i++) {
        for (int j = 0; j < list[i].length; j++) {
            builder.append(list[i][j] + "");
            if (j < list.length - 1) {
                builder.append(",");
            }
        }
        builder.append("\n");
    }

    try {
        Writer writer = new BufferedWriter(new FileWriter(file));
        try {

            writer.write(builder.toString());
        } finally {
            writer.close();
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}