List<Integer> my_list = new ArrayList<Integer>();
for (int z = 0; z<4; z++){
    System.out.println("Enter a number between 0-9. No duplicates please!");
    int input = inputDevice.nextInt();
    if(my_list.contains(input)){
        System.out.println("Duplicate found! Please enter a non-repeating digit");
        z--;
    }
    else{
        my_list.add(input);
    }
}