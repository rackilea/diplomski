File file = new File("FileTemplate.txt");
String newFile="";
try {
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if(line.contains("--NAME--")){
                line = line.replace("--NAME--", customer.getName()); 
        }
        newFile+=line;
        newFile+=System.getProperty("line.separator"); // add a newLine 
    }
    sc.close();
} 
catch (FileNotFoundException e) {
    e.printStackTrace();
}