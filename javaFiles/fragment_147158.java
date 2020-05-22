int[] a1 = new int[arr.length]; //a1 is an array of areas

for (int i=0; i < arr.length; i++) {
     Rectangle current = arr[i];
     a1[i] = current.area();
     System.out.println("a1 area: " + a1[i]); //TODO remove debugging code
     System.out.println("------------------------------------"); 
}
Arrays.sort(a1);

System.out.println("outside" + Arrays.toString(a1));