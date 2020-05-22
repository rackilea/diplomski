import java.util.ArrayList;

public static void main(String[] args)
{
     APIClass first = new APIClass();
     SecondAPIClass second = new SecondAPIClass();
     first.setInt(20);
     second.setInt(20);

     ArrayList<MyInterface> list = new ArrayList<MyInterface>();
     list.add(first);
     list.add(second);

     for(MyInterface item : list) {
          System.out.println(item.getInt());
     }
}