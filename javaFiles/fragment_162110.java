class Main {
    public static void main(String args[]) {
        String[] values = {"4,8", "1,6", "7,8", "1,5"}; // try {"4,8", "1,6", "7,8", "1,5", "1,9"}
        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        for (int i = 0; i<values.length; i++){
            String[] test = values[i].split(",");
            int nummed = Integer.parseInt(test[0]);
            int nummed2 = Integer.parseInt(test[1]);
            if (nummed2 >= right) {
                if (right != nummed2) {
                    left = Integer.MAX_VALUE;
                }
                right = nummed2;
                if (nummed < left) {
                    left = nummed;
                }
            }
        }
        System.out.println(left + "," + right);
    }
}