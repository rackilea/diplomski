public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("How many gerbils in the lab?");
    int numberOfGerbils = keyboard.nextInt();
    Gerbil[] GerbilArray = new Gerbil[numberOfGerbils]; // initialization of array

    for(int i = 0; i < numberOfGerbils; i++){
        GerbilArray[i] = new Gerbil();
        System.out.print("Lab ID:");
        // String Gerbil.id = keyboard.next(); should be replaced by
        GerbilArray[i].id=keyboard.next(); // because you should call non static members using objects of a class. Here object is an array element which requires an array index.

        System.out.print("Gerbil Nickname:");
        //String name = keyboard.next(); replace by
        GerbilArray[i].name=keyboard.next();
        // as stated earlier. and you don't need to write String again because you have already declared it in the class declaration. If you try to do this way, you are creating a new String object only. This name has already been assigned to array, so it will result in an error.
    }
}