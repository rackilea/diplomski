public static Double binaryToDecimal(String result) {
    double j=0;
for(int i=0;i<result.length();i++)
{
    if(result.charAt(i)== '1')
    {
     j= j + Math.pow(2, result.length()-1-i);
    }

}
return j;
}