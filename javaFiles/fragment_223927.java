public class ArrayDemo{
    public static void main(String[] args){
        char[] copyFrom={'a', 'b', 'c', 'e', 'f', 'g', 'g'};
        char[] copyTo=new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0,5);
        System.out.println(new String(copyTo));
    }
}