public void quickSort(int left, int right)
{
    if(a.length == 1)
    {
        System.out.println("Only one element.");
    }
    else
    {
        int l = left;
        int r = right;
        if(right > left)
        {
            Random rand = new Random();
            int num = left + rand.nextInt(right - left);
            int p = a[num];

            while(r > l)
            {
                while(a[l]<p)
                {
                    l++;
                }
                while(a[r]>p)
                {
                    r--;
                }
                if(l <= r)
                {
                    int tmp = a[l];
                    a[l] = a[r];
                    a[r] = tmp;
                    l++;
                    r--;
                }
            }

            quickSort(left,r);
            quickSort(l,right);
        }
    }
}