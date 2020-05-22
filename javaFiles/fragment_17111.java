public class FindText
{


    public static void main(String[] args)
    {
        ArrayList< String > abc = new ArrayList<>();
        abc.add("hi");
        abc.add("hello Yash");
        abc.add("i am Yash");
        String x = "Yash";

        for(int i=0; i<abc.size(); i++)
        {
            if(abc.get(i).contains(x))
            {
                int index = i;
                System.out.println(index);
            }
        }
    }
}