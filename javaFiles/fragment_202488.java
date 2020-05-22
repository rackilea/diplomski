public static void main(String[] args) {
        String str = "[17235_A, 17235_B, -1.0, 0.06838527, 1.0]";

        String[] strArray = str.split(", ");

        System.out.println(strArray[0].substring(1)); //first number
        System.out.println(strArray[1]); //second number
    }