public static void main(String[] args) {

    int s = sum(10);
    System.out.println(s);
}

static int sum(int n)
{
    if(n % 2 == 0) {
        n--;
    }
    if (n <= 1)
    {
        return 0;
    }
    return n + sum(n-2); 
}