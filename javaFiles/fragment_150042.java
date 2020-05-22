public void displayNames() {       
String[] array = {"Avon", "Berta", "Chloe", "Derek","Avon", "Berta", "Chloe", "Derek","Avon", "Berta", "Chloe", "Derek"};
        for (int i = 1; i < array.length; i++) {
            int test = i%4;
            if(test == 0 || test == 3){
                System.out.println(array[i]);
            }
        }
}