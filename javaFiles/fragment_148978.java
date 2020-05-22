class StringTest 
{
    public static void main(String[] args) 
    {
        String val= "004+0345564";
        String arr[]=val.split("\\+");
        for(int i=0;i<=arr.length-1;i++){
            System.out.println(arr[i]);
        }
    }
}