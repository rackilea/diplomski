for(int i = 0; i <= numberOfGerbils; i++){
GerbilArray[i] = new Gerbil(totalOfFood);

System.out.print("Lab ID:");
String id = keyboard.next();

System.out.print("Gerbil Nickname:");
String name = keyboard.next();

System.out.print("Bite?");
String bite = keyboard.next();

System.out.print("Escapes?");
String city = keyboard.nextLine();

for (int j = 0; j < totalFood; j++) {
    System.out.println("How many of food " + (j+1) + "do you eat?:");
    GerbilArray[i].food[j] = keyboard.nextInt();
}