Array array = {1,2,199,100,8,100,199,1001,5,9}
Array sorted = sort(array)
for (int i=1; i<sorted.length; i++)
    int p = sorted[i-1]
    int c = sorted[i]
    if (p==c) print "duplicate"