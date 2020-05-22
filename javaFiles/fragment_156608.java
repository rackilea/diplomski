public static void main(String[] args)
{
    String temp = "IP 212.98.120.24.443 > 192.168.0.12.4588 psx 12";
    if(temp.matches(".*192\\.168\\.0\\..*>.*"))
    {
        System.out.println("1st");
        //your code here
    }
    else if(temp.matches(".*>.*192\\.168\\.0\\..*"))
    {
        System.out.println("2nd");
        //your code here
    }
}