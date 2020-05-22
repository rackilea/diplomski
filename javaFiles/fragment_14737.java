public static void main(String[] args) {
    int counter=0;
    Scanner sc = new Scanner(System.in); 
    System.out.println("Write 20 numbers:");
    for(int i=0; i<20; i++) {
        System.out.print("Number " + i + ":");
        int temp =sc.nextInt(); //this waits for you to write an int
        if(temp%2==0)
            counter++;
    }
    sc.close();
    System.out.println("Even numbers:" + counter);
}