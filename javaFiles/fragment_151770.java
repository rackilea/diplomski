public static void run(ArrayList<Integer> a)
{
    int n = 10;

    for(int i = 0; i < n; i++)
        a.add(i+n); 
}

public static void main(String[] args) 
{
    ArrayList<Integer> b = new ArrayList<Integer>();

    run(b); 

    for(Integer in : b)
        System.out.println(in);
}