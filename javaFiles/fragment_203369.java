public void isBalanced(String x){

    char d = x.charAt(1);
    System.out.println(d);

    StackOfCharacters s = new StackOfCharacters();
    s.push(d);
    System.out.println(s.peek());
    System.out.println(s.empty());

}