class TestMode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] array = {1,3,2,4,5};
        int mode = mode(array);
        for (int e : array) {
            if ((mode!=0) && (e==mode)) {
                System.out.print ("["+e+"]");
            }
            else {
                System.out.print(e);
            }
            System.out.print(" ");
        }
    }

    public static int mode(int[] array) {
        int mode = array[0];
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == value) count++;
                if (count > maxCount) {
                    mode = value;
                    maxCount = count;
                    }
                }
        }
        if (maxCount > 1) {
            return mode;
        }
        return 0;
    }
}