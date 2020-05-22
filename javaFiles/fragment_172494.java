int[] number = {12, 15, 19, 21};
String[] character = {"bob", "sally", "james", "andrea"};
int userInput = ... // <<== You know how to do all that 
for (int i = 0 ; i != number.length ; i++) {
    if (number[i] == userInput) {
        // Element at index i is matching:
        System.out.println(character[i]);
        break;
    }
}