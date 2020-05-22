public class ArrayDeque {
    public static void main(String[] args) {
        ArrayDeque t = new ArrayDeque ();
        t.insertAtFirst("1");
        t.insertAtFirst("2");
        t.insertAtFirst("3");
        t.insertAtFirst("4");
        t.insertAtFirst("5");
        t.insertAtFirst("6");
        t.insertAtFirst("7");
        t.insertAtFirst("8");
        t.insertAtFirst("9");
        t.insertAtFirst("10");
        t.insertAtFirst("11");
        t.insertAtFirst("12");
        t.insertAtFirst("13");
        t.insertAtFirst("14");

        System.out.println("After first--"+t.toString());
        t.insertAtLast("1");
        t.insertAtLast("2");
        t.insertAtLast("3");
        t.insertAtLast("4");
        t.insertAtLast("5");
        t.insertAtLast("6");
        t.insertAtLast("7");
        t.insertAtLast("8");
        t.insertAtLast("9");
        t.insertAtLast("10");
        t.insertAtLast("11");
        t.insertAtLast("12");
        t.insertAtLast("13");
        t.insertAtLast("14");
        System.out.println("After last--"+t.toString());
    }
    private static final int INIT_CAPACITY = 5;             

    private int NEW_CAPACITY;
    private int ARRAY_SIZE;
    private Object[] arr;                           


    public TestClass(){

        arr = new Object[ INIT_CAPACITY ];

        NEW_CAPACITY = INIT_CAPACITY;
        ARRAY_SIZE = 0;
    }   


    public void insertAtFirst(Object item){

        if(ARRAY_SIZE == 0)
        {
            arr[0] = item;
            ARRAY_SIZE++;
        }
        else if(ARRAY_SIZE+1 < arr.length)
        {
            Object[] tmp = new Object[NEW_CAPACITY];
             for(int i = 1; i < arr.length; ++i)
                tmp[i] = (String)arr[i-1];

            arr = tmp;
            arr[0] = item;
            ARRAY_SIZE++;
        }
        else if(ARRAY_SIZE+1 >= arr.length)
        {
            NEW_CAPACITY = NEW_CAPACITY+INIT_CAPACITY;
            Object[] tmp = new Object[NEW_CAPACITY];
             for(int i = 1; i < arr.length; ++i)
                tmp[i] = (String)arr[i-1];

            arr = tmp;
            arr[0] = item;
            ARRAY_SIZE++;
        }
    }


    public void insertAtLast(Object item){

        if(ARRAY_SIZE == 0)
        {
            arr[0] = item;
            ARRAY_SIZE++;
        }
        else if(ARRAY_SIZE+1 < arr.length)
        {

            arr[ARRAY_SIZE] = item;
            ARRAY_SIZE++;
        }
        else if(ARRAY_SIZE+1 >= arr.length)
        {
            NEW_CAPACITY = NEW_CAPACITY+INIT_CAPACITY;
            Object[] tmp = new Object[NEW_CAPACITY];
             for(int i = 0; i < arr.length; ++i)
                tmp[i] = (String)arr[i];

            arr = tmp;

            arr[ARRAY_SIZE] = item;
            ARRAY_SIZE++;
        }
    }


    public int size(){

        return ARRAY_SIZE;      
    }   


    public boolean isEmpty(){

        return (ARRAY_SIZE == 0);

    }   


    public String toString(){

        String s = "";
        for(int i = 0; i < arr.length; ++i)
            s += arr[i] + "\t";
        return s;
    }   
}