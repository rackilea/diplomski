public static String[] splitWise(String line,char a){
    String[] res= {"",""};
    Boolean added=false;
    for(int i=0;i<line.length()-1;i++)
    {
        if(line.charAt(i)==a)
        {
            //change next line if you want the element you split in the second element of the array
            res[0]+= line.charAt(i);
            added=true;
        }else if(!added){
            res[0] += line.charAt(i);

        }else
            res[1] += line.charAt(i);

    }
    return res;
}