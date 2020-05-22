public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    // the HashMap now needs to store Strings and ArrayLists
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    // the ArrayList replaces your HashSet.
    ArrayList<String> list = new ArrayList<String>();   // I called it list so you we can see the difference :)

    Random r = new Random();

    list.add("How are you");
    list.add("Whats up");
    list.add("How Have You Been");
    list.add("Missed Me");
    list.add("ab");
    list.add("cd");
    list.add("Excuse me no no");

    map.put("hi", list);

    System.out.println("enter Hi");
    String str = input.next().toLowerCase().trim();

    if (map.containsKey(str)) {
        ArrayList<String> tmpList = map.get(str);  // this is just make the step clear, that we now retrieve an ArrayList from the map
        int randomNumber = r.nextInt(tmpList.size()) // a random number between 0 and tmpList.size() 
        System.out.println(tmpList.get(randomNumber)); // get the random response from the list
    }
}