public class arrayformat {

    public static void main(String[] s)
    {
                int[] array = {1,2,3,4,5};


                int temp = array[4];

                for(int i=array.length-1;i>0;i--)
                {
                    array[i]=array[i-1];
                }

                array[0]= temp;

                for(int i=0;i<array.length;i++)
                {
                    System.out.println(array[i]);
                }

    }
}