1    int[] data;
2    int size;
3
4    public boolean binarySearch(int key) 
5    {
6         int low = 0;
7         int high = size - 1;
8          
9         while(high >= low) {
10             int middle = (low + high) / 2;
11             if(data[middle] == key) {
12                 return true;
13             }
14             if(data[middle] < key) {
15                 low = middle + 1;
16             }
17             if(data[middle] > key) {
18                 high = middle - 1;
19             }
20        }
21        return false;
22   }