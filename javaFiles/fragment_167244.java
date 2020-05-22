int numberOfPigs = Integer.parseInt(keyboard.nextLine());
Pigs pigArray = new pigs[numberOfPigs];
String[] tempArray = new String[numberOfPigs]; // I moved this here see
                                                    // comment below
for (int i = 0; i < pigArray.length; i++) {
System.out.println("Pig name: " + (i + 1));
String name = keyboard.nextLine();
// first problem was you were redeclaring your tempArray here
// thereby erasing previous elements over every iteration of i
tempArray[i] = name;
for (int k = i - 1; k >= 0; k--) { // you need to count backwards
                        //you only check what was already entered for duplicates
                         // you were doing the opposite
while (tempArray[i].equals(tempArray[k])) {
    System.out.println("The ID is duplicate.");
    tempArray[i] = keyboard.nextLine();
}
System.out.println(" Not a duplicate! Yay.");
}// k loop
}// i loop