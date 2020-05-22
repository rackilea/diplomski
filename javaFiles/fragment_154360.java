public  String[]  reverseString(String[] words)
{
    String[] t=new String[words.length];

    for(int i=0;i<words.length;i++)
    {   
        //added for setting elemennt as emptyString instead of null
        t[i] = "";
        for(int j=words[i].length()-1;j>=0;j--)
        {
            t[i]+=words[i].substring(j,j+1);
        }
    }

    //using loop
    for(int i=0;i<words.length;i++)
    {
         System.out.println(t[i]);
    }
    //using Arrays Method
    System.out.println(Arrays.toString(t));
    return t;
}