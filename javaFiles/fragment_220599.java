public static void main(String[] args) {
    try {
        BufferedReader br = new BufferedReader
                (new InputStreamReader(System.in));

        String[] temp = new String[7];
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.println("Please enter the temperature for the " + (i + 1) + " day of the week"); //Not the most gramatically correct. But i did what i could while using the loop.
            temp[i] = br.readLine();
            arr[i] = Integer.parseInt(temp[i]); // **
        }

        System.out.println("The temperature for Monday is: " + temp[0]);
        System.out.println("The temperature for Tuesday is: " + temp[1]);
        System.out.println("The temperature for Wednesday is: " + temp[2]);
        System.out.println("The temperature for Thursday is: " + temp[3]);
        System.out.println("The temperature for Friday is: " + temp[4]);
        System.out.println("The temperature for Saturday is: " + temp[5]);
        System.out.println("The temperature for Sunday is: " + temp[6]);

        double avg = averageValue(arr);
        System.out.println("Avg Temp for the week is: \t\t " + avg);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static double averageValue(int[] arr) {
    double average = 0;
    for (int i = 0; i < arr.length; i++) {
        average += arr[i];
    }
    return average / arr.length;
}