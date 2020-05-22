public static byte[] toByteArray(String[] arr) {
    byte[] res = new byte[arr.length];

    for (int i = 0; i < arr.length; i++) {
        try {
            res[i] = Byte.parseByte(arr[i]);    
        } catch(Exception e) {
            res[i] = // TODO action for incorrect value
        }
    }

    return res;
}