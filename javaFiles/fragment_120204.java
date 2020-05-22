Scanner scan = new Scanner(System.in);
int[] arr1 = new int[]{1,2,3};
int[] arr2 = new int[arr1.length];
for (int i = 0 ; i < arr1.length ; i++) {
  System.out.println("Enter numbers to check");
  arr2[i] = scan.nextInt();
  if (arr1[i] != arr2[i])
    return false;
}
return true;