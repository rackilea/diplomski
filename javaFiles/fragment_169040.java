public static void main(String[] args) {
        int length = 14;

        //To provide a string
        String res1="";
        for(int i=0;i<length;i++) res1+='1';
        System.out.println(res1);

        //To provide an int
        int res2=0;
        for(int i=0;i<length;i++) res2+=Math.pow(2, i);
        System.out.println(Integer.toBinaryString(res2));
    }