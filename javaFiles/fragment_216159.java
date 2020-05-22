private int numVowels() //FIXED METHOD
{
    String vowels = "AEIOUaeiou";
    int vowelCount = 0;

    for(int i = 0; i < vowels.length(); i++)
    {
        if((vowels.charAt(i) == 'a') || (vowels.charAt(i) == 'e')  || (vowels.charAt(i) == 'i') || (vowels.charAt(i) == 'o') || (vowels.charAt(i) == 'u') || (vowels.charAt(i) == 'A') || (vowels.charAt(i) == 'E') || (vowels.charAt(i) == 'I') || (vowels.charAt(i) == 'O') || (vowels.charAt(i) == 'U'))      
        {
            return vowelCount; //Will return lowercase AND capital vowels :)
        }
    }
    return vowelCount;
}