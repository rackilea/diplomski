Scanner cin = new Scanner(System.in);
    System.out.print("Enter a query: ");
    String input = cin.nextLine();
    try{
        String line;
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
        while((line = br.readLine()) != null){
            String[] words = line.split(" ");
            for(String w: words) {
                String p = "^" + input.replaceAll("\\*", ".*") + "$";
                if (w.matches(p)) {
                    System.out.println(w);
                }
            }
        }

    }catch (IOException e){
        e.printStackTrace();
    }

    System.exit(0);
}