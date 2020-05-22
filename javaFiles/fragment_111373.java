static int[] intArray = {5, 6, 10, 4};

public static void main(String[] args){
        for (int i = 0; i < intArray.length; i++){ // Iterate through the int array
            for(int j = 0; j < intArray[i]; j++){ // loop intArray[i] times
                System.out.print("" + "*");
            }
            System.out.println(": "  );
        }
    }