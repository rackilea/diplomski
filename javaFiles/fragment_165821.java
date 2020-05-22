// Display all correct guesses
String strText = ""; // reset the display
boolean allFound = true;

for (int i = 0; i < strSecret.length(); i++)
{
    char ch = strSecret.charAt(i); // get each character from strSecret

    // To check if this letter can be found in strGuess
    if (strGuess.indexOf(ch) >= 0)
    {
        // found
        strText += ch;
    }
    else
    {
        // Not found
        strText += "-";
        allFound = false;
    }

}

if(allFound)
{
    // Word was guessed correctly
    [...]
}