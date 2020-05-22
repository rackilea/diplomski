private static String extractFirstEqual(String a, String b) {

    //Split your string into an array of characters
    String[] arr = a.split("");
    String[] brr = b.split("");
    StringBuilder result = new StringBuilder();

    //Iterate over both arrays
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < brr.length; j++) {
            //Find first matching character
            if (arr[i].equals( brr[j])) {
                //While there are more characters in both arrays and the characters keep matching, append them
                // to the result
                while (arr[i].equals(brr[j]) && i < arr.length && j < brr.length) {
                    result.append(arr[i]);
                    i++;
                    j++;
                }

                return result.toString();
            }
        }
    }

    return result.toString();
}