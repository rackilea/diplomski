public static void main(String[] args) {
    try { 
        Scanner s = new Scanner(new FileReader("/Users/daniel/pr/java/readFile/myfile.txt"));  // Line 9
    } catch (FileNotFoundException e) {
        //do something with e, or handle this case
    }
}