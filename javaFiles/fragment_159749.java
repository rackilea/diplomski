public static void main(String args[]) {
        String name = "daac";
        char com[] = name.toCharArray();

        char[] con = new char[4];
        for (int i = 0, j = 3; i < com.length; i++, j--) {
            con[j] = com[i];
            System.out.println(i + " " + j + "value of i " + com[i] +" "+con[j]);

        }

    }