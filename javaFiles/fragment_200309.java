class HeapAlgo {
    // create a writer at the class level
    private PrintWriter _pw;

    // Create a constructor to assign the writer
    public HeapAlgo(PrintWriter pw) {
       this._pw = pw;
    }

    void heapPermutation(String a[], int size, int n) throws IOException { 
    // if size becomes 1 then prints the obtained 
    // permutation 
        if (size == 1) 
            for (int i=0; i<n; i++) { 
                System.out.println(a[i] + "");
                this._pw.print(a[i] + ""); // print here I belive?
            }

        for (int i=0; i<size; i++) { 
            heapPermutation(a, size-1, n); 

            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) { 
                String temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            }

            // If size is even, swap ith and last 
            // element 
            else { 
               String temp = a[i]; 
               a[i] = a[size-1]; 
               a[size-1] = temp; 
            } 
        }
    }
}

public static void main(String args[]) throws IOException {
    FileWriter fw = new FileWriter("note.txt");
    PrintWriter pw = new PrintWriter(fw);
    HeapAlgo obj = new HeapAlgo(pw); // Pass in a writer
    String a[] = new String["abcd","bbbb","cccc","dddd"];
    obj.heapPermutation(a, a.length, a.length);