public class Testing {

class Personnel {
    String name;
    String initials;
    int age;
    Personnel(String name, String initials, int age) {
        this.name = name;
        this.initials = initials;
        this.age = age;
    }
}

void readData() {
    File inputFile = new File ("Personnel.txt");
    FileReader in = null;
    BufferedReader inFromFile = null;
    ArrayList<Personnel> data = null;
    try {
        in = new FileReader (inputFile);
        inFromFile = new BufferedReader (in);

        // list that will hold all personnel objects
        data = new ArrayList<Personnel>();
        String line = inFromFile.readLine ();

        while (line != null) {
            String [] field = line.split("([,#])");
            String name = field[0]; // field[0] = "Richard"
            String initials = field[1]; // field[1] = "RL"
            int age = Integer.valueOf(field[2]);// field[2] = "17";
            data.add(new Personnel (name, initials, age));
            line = inFromFile.readLine();
        }
        inFromFile.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } 

    for(Personnel p : data) {
        System.out.println("Name:\t\t" + p.name);
        System.out.println("Initials:\t" + p.initials);
        System.out.println("Age:\t\t" + p.age);
        System.out.println();
    }
}

public static void main(String[] args) {
    Testing test = new Testing();
    test.readData();
}

}