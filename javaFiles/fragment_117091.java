public void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    BufferedReader console = 
            new BufferedReader(new InputStreamReader(System.in));
    while(true) {
        String word = console.readLine();
        if (word.equalsIgnoreCase("end") {
            break;
        } else {
            numbers.add(Integer.parseInt(word);
        }
    }