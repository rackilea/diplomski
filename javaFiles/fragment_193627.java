if (lettersFound[i]==true)//Checks if a letter was already revealed at that position
{
    System.out.print(word.charAt(i)+" ");
    //Deleted line here
}
else if (word.charAt(i)==letter)//Prints the correctly guessed letter at the position
{
    System.out.print(word.charAt(i)+" ");
    lettersFound[i] = true;
    goodGuess = true;
    corLetters++;
}