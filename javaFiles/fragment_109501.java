public static void main(String[] args){     

    List<Name> list = new ArrayList<Name>();

    loadFile();

    System.out.println(list.get(0).getPop());
}

private static void loadFile(){
    Scanner inputStream = null;
    String fileName = "names.txt";

    try {
        inputStream = new Scanner (new File(fileName));
    }
    catch (FileNotFoundException e){
        System.out.println("Error opening file named: " + fileName);
        System.out.println("Exiting...");
    }

    while (inputStream.hasNext()){
        // givenName = something
        // ranks = something;

        list.add(new Name(givenName, ranks);
    }
}