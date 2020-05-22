package test;

public class Genric<E>
{
    public Genric(E c){
        System.out.println(c.getClass().getName());
    }   
    public static void main(String[] args) {
        new Genric<Integer[]>(new Integer[]{1,2});
    }
}