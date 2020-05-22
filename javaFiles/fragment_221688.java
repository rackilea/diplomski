class SquareIt {
    BufferedReader myInput;
    String input;
    int num;
    public SquareIt() throws IOException, NumberFormatException {
        myInput = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("1-12");
        input = myInput.readLine();
        num = Integer.parseInt (input);
    } ....