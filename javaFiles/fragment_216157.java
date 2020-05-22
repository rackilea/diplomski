public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] code = input.split(" ");
        for(String splits : code){
            System.out.println(splits);
        }
    }