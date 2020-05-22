HashMap<Character, Integer> map = new HashMap<Character, Integer>();
BufferedReader in = new BufferedReader(new FileReader("letters.txt"));
while(in.readLine() != null) {
    String line = in.readLine();
    //TODO you need to split the string by ';' and get the char and int
    char c = ...
    int x = ...
    set.put(c,x);
}


BufferedReader in = new BufferedReader(new FileReader("random_words.txt"));
while(in.readLine() != null) {
    String line = in.readLine();
    int total = 0;
    for(int i = 0; i < line.length(); i++)
    {
        char c = line.charAt(i);
        //TODO get integer value from map, add it to the total, and print it after the loop
        int value = ...
        total += value;
    }
    System.out.println("value for word " + line + " is " + total);
}