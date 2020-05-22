public static void main (String[] args) throws java.lang.Exception
{
    int b[] = {10, 9, 8, 7, 7, 7, 7, 3, 2, 1};
    sort(b,0,b.length-1);
    System.out.println(Arrays.toString(b));
}

static void sort(int a[], int left, int right)   {  
   if (right > left){
    int i=left, j=right, tmp;    
    //we want j to be right, not right-1 since that leaves out a number during recursion

    int v = a[right]; //pivot

    do {
        while(a[i]<v)
          i++;
        while(a[j]>v) 
        //no need to check for 0, the right condition for recursion is the 2 if statements below.
          j--;

        if( i <= j){            //your code was i<j
           tmp = a[i];
           a[i] = a[j];
           a[j] = tmp;
           i++;            
           j--;
           //we need to +/- both i,j, else it will stick at 0 or be same number
        }
   } while(i <= j);           //your code was i<j, hence infinite loop on 0 case

    //you had a swap here, I don't think it's needed.
    //this is the 2 conditions we need to avoid infinite loops
    // check if left < j, if it isn't, it's already sorted. Done

    if(left < j)  sort(a,left,j);
    //check if i is less than right, if it isn't it's already sorted. Done
    // here i is now the 'middle index', the slice for divide and conquer.

    if(i < right) sort(a,i,right);
  }