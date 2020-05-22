public char mostFreq(String str){

    int highestFreq = 0;

      char mostFreqChar = ' ';

      for (int i = 0; i < str.length(); i++)

      {

          //Get a char and go through entire string to determine how many times that char occurs

          char x = str.charAt(i);
          int c = 0;

          for (int j = str.indexOf(x); j != -1; j = str.indexOf(x, j + 1))

          {

              c++;

          }

          if (c > highestFreq)

          {

              highestFreq = c;

              mostFreqChar = x;
          }

      }

      return mostFreqChar;
}