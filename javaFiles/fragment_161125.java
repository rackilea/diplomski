for(int i=0; i<np; i++){
        giver=f.readLine();
        String assumedNumbers = f.readline();
        try {
            String[] numbers =f.readLine().split("\\s");
            System.out.println(giver+" "+numbers[0]+" "+numbers[1]);
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println( "INVALID NUMBERS LINE '" + assumedNumbers + "'" );
            throw( e );
        }
}