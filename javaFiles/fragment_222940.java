public void intToNum(String s, int total[])
{

     if(s.isEmpty())
        return;

     char c = s.charAt(0);

if (Character.isDigit(c)){
            int value=Character.getNumericValue(c);
            total[0] +=value;
        }

intToNum(s.substring(1),total);

}