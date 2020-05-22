public static void main(String[] args) throws Exception {
        String filepath= "C:\\Users\\Demo\\Desktop\\batch\\Demo.sh";
        FileInputStream fis = new FileInputStream(filepath);
        InputStreamReader input = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(input);
        String data;
        String result = new String();
        int lineNumber=0;
        int i=0;

    while ((data = br.readLine()) != null) {
        i++;
        if(data.contains("My String data")) {
            System.out.println("line number -> "+i);
            lineNumber=i;
            break;
        }
        result = result.concat(data + "\n");
    }
    br.close();
    lineNumber=lineNumber+1;
    System.out.println(lineNumber);
    String Mystring ="    Mystring";
    String Mystringline = Files.readAllLines(Paths.get(filepath)).get(lineNumber-1); // get method count from 0 so -1
    System.out.println("Line data ->> "+Mystringline);
    if(!Mystringline.equalsIgnoreCase(Mystring)) {
         setVariable(lineNumber, Mystring, filepath);
    }else {
        System.out.println("Mystring is already pointing to correct DB");
    }
    System.out.println("Succesfully Change");
}

public static void setVariable(int lineNumber, String data, String filepath) throws IOException {
    Path path = Paths.get(filepath);
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    lines.set(lineNumber - 1, data);
    Files.write(path, lines, StandardCharsets.UTF_8);
}
}