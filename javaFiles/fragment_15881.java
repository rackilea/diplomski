void print(int x[], int start)
{
    if (start < x.length) {
        if (start > 0) {
            System.out.println(x[start] + ",");
        }
        print(x, start + 1);
    }
}