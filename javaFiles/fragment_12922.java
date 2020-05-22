public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner inp = new Scanner(System.in);
    int i=0;
    String in = inp.nextLine();
    while(i==0){
        if(in.equals("x")){
            System.out.println("> y");
            //in = inp.nextLine(); remove this
        }
        in = inp.nextLine();
    }
}