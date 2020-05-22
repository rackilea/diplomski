Method 1:

We can print array without using loop or recursion as

  char [] crr = {'A','B','C','D','E','F'};

  System.out.println(" Print Array ="+ Arrays.toString(crr));

Output: Print Array =[A, B, C, D, E, F] 


Method 2: Firstly we make arraylist from array and then print it .

    String [] brr ={"HTML","PHP","JAVA","C"};

    ArrayList<String> arr= new ArrayList<String>(Arrays.asList(brr));

    System.out.println("ArrayList Is ="+arr);