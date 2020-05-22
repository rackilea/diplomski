String dictionary_str = 
        "AL" + "\n"
        +"BAL" + "\n"
        +"BAK" + "\n"
        +"LABAT" + "\n"
        +"TAL" + "\n"
        +"LAT" + "\n"
        +"BALAT" + "\n"
        +"LA" + "\n"
        +"AB" + "\n"
        +"LATAB" + "\n"
        +"TAB" + "\n";
String[] dictionary = dictionary_str.split("\n"); // Split into lines
for (int i=0; i<dictionary.length; i++)   // Iterate through lines
{
    if(dictionary[i].indexOf("B") > -1 && // There must be B
       dictionary[i].indexOf("T") > -1 && // There must be T
       dictionary[i].indexOf("L") > -1)   // There must be L
    {
        System.out.println("Match: " + dictionary[i]); // No need matching, print the whole line
    }
}