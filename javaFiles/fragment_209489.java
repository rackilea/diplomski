public static void main(String[] args) {
    String line = "xyzwrdxyrs";
    String input;
    String encrypt =  line.replaceAll("[^ ]","-");
    System.out.println(encrypt);
    System.out.println(line);
    Scanner scanner = new Scanner(System.in);
    for (int j=0;j<10;j++) { //Asks 10 times for user input
        input = scanner.nextLine();
        //int check = line.indexOf(input);
        int pos = -1;
        int startIndex = 0;
        //loop until you all positions of 'input' in 'line'
        while ((pos = line.indexOf(input,startIndex)) != -1) {
            //System.out.println(check);
            // you need to construct a new string using substring and replacing character at position
            encrypt = encrypt.substring(0, pos) + input + encrypt.substring(pos + 1);
            //check = line.indexOf(input, check + 1);
            startIndex = pos+1;//increment the startIndex,so we will start searching from next character
        }
        System.out.println(encrypt);
    }
}