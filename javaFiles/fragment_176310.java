File file = new File("path to your file");

try {

    Scanner sc = new Scanner(file);
    String line = null;
    while (sc.hasNextLine()) {
       line = sc.nextLine();
        jTextArea1.append(line+"\n");
    }
    sc.close();
} 
catch (FileNotFoundException e) {
    e.printStackTrace();
}