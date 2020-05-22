private static Scanner s;
void methodName(){
    try {
        s = new Scanner(new File("walking2.txt"));
        //..your code
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}