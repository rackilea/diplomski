public int Cal(String ab) 
{
    String[] arr=ab.split(":");
    int av = ( Integer.parseInt(arr[0].trim())*60 +  Integer.parseInt(arr[1].trim()))*1000;
    return av;
}