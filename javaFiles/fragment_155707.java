String vowels = "aAeEiIoOuU";
    int found = 0;
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter any word: ");
    String inputStr = sc.nextLine();
    for (int i = 0; i < inputStr.length(); i++) {
        if (vowels.indexOf(inputStr.charAt(i)) >= 0) {
            found += 1;
        }
    }