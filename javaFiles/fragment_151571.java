1    public static void findCollections(int[] array, int index, int currentPosition, int sum, String collection) {
2        if(array.length < index || currentPosition > sum)
3            return;
4        for(int i = index; i < array.length; i++) {
5            if(currentPosition + array[i] == sum) {
6                System.out.println(collection + " " + array[i]);
7            }
8            else if(currentPosition + array[i] < sum) {
9                findCollections(array, i + 1, currentPosition + array[i], sum, collection + " " + array[i]);
10           }
11       }
12   }

...

1    -
2    1
3    1
4    n+1
5    n
6    n
7    -
8    n
9    n*T(n-1)
10   -
11   -
12   -