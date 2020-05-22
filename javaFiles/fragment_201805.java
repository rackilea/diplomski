public static int printArray (int[] [] arr) {
    System.out.println("["); {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for(int j = 0; j < arr[i].length; j++) 
            {System.out.print(arr[i][j]); 
            if (j<arr[i].length-1) {
                System.out.print(", ");}
            }
            System.out.println("]");
        }
    }
    System.out.println("]");
    return 0;   
}