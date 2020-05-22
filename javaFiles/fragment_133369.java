//Update hidden array with _ or correct char
for(int i=0; i < secretWord.length(); i++)
{
    if (position == 0)
    {
    hidden[i] = '_';
    }
    else if (position != 0)
    {
       hidden[position-1] = test;     
    }
    System.out.print(hidden[i] + " ");
}