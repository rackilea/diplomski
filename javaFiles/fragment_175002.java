`BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    }
    try {
        while ((line = reader.readLine()) != null) {
        System.out.println(StringEscapeUtils.escapeJava(line));
        }
    }`