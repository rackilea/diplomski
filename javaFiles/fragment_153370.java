char[] rndword; //put the word they are trying to guess here
char[] display; //show this one to the user (start by populating it with dashes and / or spaces)

for(int e = 0; e < rndword.length; e++) {
    if(rndword[e] == guess.charAt(0))
    {
        display[e] = guess.charAt(0);
    }
    System.out.print(display[e]);
}
System.out.println();