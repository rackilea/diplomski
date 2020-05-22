public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    System.out.println("Enter the filename:");
    String file = input.nextLine();

    System.out.println("file name is "+ file);
    ESPInterpreter readFile = new ESPInterpreter();
    readFile.read(file);
    ESPInterpreter sample = new ESPInterpreter();
    sample.ShowHowToUseVariableClass();
}