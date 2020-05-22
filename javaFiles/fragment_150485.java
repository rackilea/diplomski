public class IO {
public static void main (String[] args){
    fileInput();
}
public static ArrayList<Integer> fileInput() {
    //variable setup
    String file = "src/seats.txt";
    int number;

    ArrayList<Integer> numbers = new ArrayList<Integer>();


    //Read file into the ArrayLists
    try {
        Scanner input = new Scanner(new FileReader(file));

        while (input.hasNextLine()){    //read a line from file
            number = input.nextInt();
            input.nextLine();

            numbers.add(number);
        }
        input.close();
    }
    catch (IOException e){
        System.out.println(e);
    }
    return numbers;
}
}