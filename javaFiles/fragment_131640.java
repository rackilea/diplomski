public void calMode()
{
    // This array will allow for indexes from 0 to 100 
    // (the same range as a grade on a 0-100 scale)
    int []a=new int[101];

    int i,m; // these are just temporary indexes

    // You don't need to do this, an int in java is set to 0 by default
    // as is an array of ints
    for(i=0;i<=grade.length;i++) 
         a[i]=0;

    // Here you are looking at each grade and incrementing the occurrences of each
    // where each index is the grade and the value stored at that index is the number
    // of times that grade appears
    for(i=0;i<grade.length;i++)
        a[grade[i]]++;
    m=0;

    // Here you are finding which grade has the highest frequency (the mode)
    // by comparing the values you calculated in the previous loop
    for(i=0;i<a.length;i++)
        if(a[i]>a[m])
            m=i;
        mode=m;
}