List<Person> list = new ArrayList<Person>();
String line;
try (
    // open an input stream
    InputStream fileInputStream = new FileInputStream("".../testing"");

    // read file as UTF-8
    InputStreamReader reader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));

    // open a BufferedReader to read line-by-line
    BufferedReader br = new BufferedReader(reader);
) {
    while ((line = br.readLine()) != null) {
        // split the `line` on ";"
        // [0] - ID    
        // [1] - FName   
        // [2] - LName          
        // [3] - City             
        // [4] - Age
        String[] objects = line.split(";");
        int ID = Integer.parseInt(objects[0]);
        String fName = objects[1];
        String lName = objects[2];
        String city = objects[3];
        int age = Integer.parseInt(objects[4]);
        list.add( new Person(ID, fName, lName, city, age) );
    }
}

System.out.println(list);