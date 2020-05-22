public class test{
    public static void main(String [] args){
        other h = new other();
        h.g();
        int num = h.getV();
        System.out.println(num);
    }
}

public class other{
    public int book = 0;
    public void g(){
        book++;
        book++;
    }
    public int getV(){
        return (book);
    }
}