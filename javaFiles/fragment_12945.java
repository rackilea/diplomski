public Stack<Character> einlesen(){
    Scanner sc = new Scanner(System.in);
    Stack<Character> st = new Stack<>();
    System.out.println("Bitte geben Sie einen Text ein: ");
    if (sc.hasNextLine()) {
        String str = sc.nextLine();
        for (char ch : str.toCharArray()) {
            st.push(ch);
        }
    }
    return st;
}