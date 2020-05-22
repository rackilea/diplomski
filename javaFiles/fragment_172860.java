boolean isMagicNumber(String number)
{

    int[] digits = new int[number.length()];
    int sum = 99;

    while(sum/10 >= 1)
    {
          sum = 0;
          for(int i = 0; i < number.length(); i++)
          {
              sum += Integer.parseInt(""+number.charAt(i));
          }

          if(sum == 1)
          {
               return true;
          }
    }

    return false;
}