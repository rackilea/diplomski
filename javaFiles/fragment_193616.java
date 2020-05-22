public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String user;
    String a = input.nextLine();
    String b = input.nextLine();
    String c = input.nextLine();
    input.close();

    int countOfA = findLowerCaseNumber(a);
    int countOfB = findLowerCaseNumber(b);
    int countOfC = findLowerCaseNumber(c);

    if(countOfA > countOfB && countOfA > countOfC){
        System.out.println(a + " has the highest number of lowercase letters " + countOfA );
        if(countOfB < countOfC)
            System.out.println(b + " has the lowest number of lowercase letters " + countOfB );
        else
            System.out.println(c + " has the lowest number of lowercase letters " + countOfC );
    }
    else if(countOfB > countOfA && countOfB > countOfC){
        System.out.println(b + " has the highest number of lowercase letters " + countOfB );
        if(countOfA < countOfC)
            System.out.println(a + " has the lowest number of lowercase letters " + countOfA );
        else
            System.out.println(c + " has the lowest number of lowercase letters " + countOfC );
    }
    else {
        System.out.println(c + " has the highest number of lowercase letters " + countOfC );
        if(countOfB < countOfC)
            System.out.println(b + " has the lowest number of lowercase letters " + countOfB );
        else
            System.out.println(a + " has the lowest number of lowercase letters " + countOfA );
    }
}

public static int findLowerCaseNumber(String str){
    int lowerCaseLetters = 0;
    for(int i = 0; i < str.length(); i++)
        // I prefer to use the ASCII values of lower case letters but what you have used is also correct.
        if(str.charAt(i) > 96 && str.charAt(i) < 123)
            lowerCaseLetters++;
    return lowerCaseLetters;
}