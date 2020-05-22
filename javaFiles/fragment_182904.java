for(int a = 0; a < word_1.length(); a++)
{
    char mychar = word_1.charAt(a);

    // flag for matching letters
    Boolean found = false;

    // you go through only previous characters!
    for(int c = 0; !found && c < a; c++)
    {
        char mychar_2 = word_1.charAt(c);
        if(mychar == mychar_2)
        {
            found = true;
        }
    }

    // here you add character if no match found
    if(!found) {
        word_3 = word_3 + mychar;
    }
}