public static void main(String[] args) {
    RotationDemo rd = new RotationDemo();
    int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    int k = 0;
    Scanner scan = new Scanner (System.in);
    try{
         System.out.println("\nEnter the shift/rotation:");
         int shiftNum = scan.nextInt();
         if(shiftNum < 30) {
             k = shiftNum;
             System.out.println("Rotate given array " + Arrays.toString(input));
             int[] rotatedArray = rd.rotateRight(input, input.length, k);
             System.out.println("After Rotate  " + 
                  Arrays.toString(rotatedArray));
         } else {
            System.out.println("Shift number should be less than 30");
         }
         } catch(Exception ex){
         } finally {
            scan.close();
        }
      }
      public int[] rotateRight(int[] input, int length, int numOfRotations) {
        for (int i = 0; i < numOfRotations; i++) {
          int temp = input[length - 1];
          for (int j = length - 1; j > 0; j--) {
            input[j] = input[j - 1];
          }
          input[0] = temp;
        }
        return input;
      }