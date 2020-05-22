1. Int cover = -1, points= new array
2. For each i in the array.length:
    2.1 If array[i] > cover then:
        2.1.1 cover = array[i] //element can cover itself 
        2.1.2 for (j=i+1; array[j] < array[i] + range; j++) // find the largest element who still cover array[i]
            2.1.2.1 cover = array[j] // element in index j cover also index i
        2.1.3 push to point cover value
        2.1.4 add range to cover // to mark for cover after a[j]