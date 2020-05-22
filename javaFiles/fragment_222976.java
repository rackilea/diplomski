public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Box> boxList = new  ArrayList<Box>();
    Box box = new Box(); // Uses the `dummy` constructor
    System.out.println("Box type?\t");
    box.setType(input.next());
    System.out.println("Box model?\t");
    box.setModel(input.next());
    // And so on
    boxList.add(box);
    // Add as many boxes as you need
}