public static void main(String[] args) {

    List<String> out = new ArrayList<String>();

    try {
        Scanner console = new Scanner (System.in);
        System.out.println("> ");
        String input = console.nextLine();
        out.add(input);

        while (!input.equals("quit")){ 
            input = console.next();
            out.add(input);
        }
        }catch (Exception e){
            System.out.println("Error: Invalid Input");
        }

        for(int i = out.size() - 1; i >=0; i--){
            System.out.println(out.get(i));
        }

        System.out.println("Bye!"); 
}