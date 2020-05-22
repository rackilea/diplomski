public class Test {

public static void main(String args[])
{
    LinkedList<String> dataList = new LinkedList<String>();
    for(int i=0;i < 5;i++)
    {
        dataList.add("test"+i);
    }

    System.out.println(dataList.indexOf("test3"));

}

}