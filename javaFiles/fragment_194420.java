class S {

    public static void main(String[] args) {
        Scanner fileScan= new Scanner("hi my name is mario!").useDelimiter("[ ,!?.]+");
        String word;
        while(fileScan.hasNext()){       
            word= fileScan.next();
            System.out.println(word);
        }

    } // end of main()
}


javac -g S.java && java S
hi
my
name
is
mario