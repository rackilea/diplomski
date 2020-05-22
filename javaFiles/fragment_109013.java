public static int[] Sort(int a[]){
        for(int i=1;i<a.length;i++){
            int term=a[i];
            int j=i-1;

            //Sorting
            while(j>=0 && term<a[j]){
                a[j+1]=a[j];
                j--;
            }

            a[j+1]=term;
        }

        return a;
    }