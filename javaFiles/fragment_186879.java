public static void main(String[] args) {
        int myInt = 1234567890;
        StringBuilder str = new StringBuilder(String.valueOf(myInt));

        int length = str.length();
        int count = 0;

        for (int i = length; i > 0; i--) {
            count++;

            if (count % 3 == 0 && count != length) {                
                str.insert(i - 1, ",");
            } 
        }
        System.out.println("Formatted Number: " + str);

    }