class ravindra {
    public static void main(String[] args) {
        int[] ia = new int[10];
try{
        for (int i = 0; i < ia.length; i++)
            ia[i] = i;
        int sum = 0;
        for (int i = 0; i < ia.length; i++)
            sum += ia[i];
        System.out.println(sum);
}
catch(ArrayIndexOutOfBoundsException e)
{
//system.out.println("exception");
}
    }
}