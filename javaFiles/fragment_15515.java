try {

    FileWriter fileWriter = new FileWriter("filename.yaml");

    String text = "#Some random Cometary\n"
                + "RandomText: Goes Here,\n"
                + "Number: 10,\n"
                + "isBoolean: true";

    fileWriter.write(text);
    fileWriter.close();


} catch (Exception e) {};