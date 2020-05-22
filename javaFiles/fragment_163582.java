public static CarteMere[] chargerEnMemoire(String nomFichier) throws IOException{
    CarteMere[] newCarteMere = new CarteMere[0];
    try {
        FileReader reader = new FileReader( nomFichier );
        BufferedReader buffer = new BufferedReader( reader );
        int nmLines = 0;
        while ( buffer.readLine() != null) {
            nmLines++; // To evaluate the size of the table
                        }
        buffer.close();
        reader.close();
        //RESET THE BUFFER AND READER TO GET ON TOP OF THE FILE
        FileReader reader2 = new FileReader( nomFichier );
        BufferedReader buffer2 = new BufferedReader( reader2 );
        newCarteMere = new CarteMere[nmLines/3];
        for(int i=0; i<(nmLines/3);i++){
            int forme = CarteMere.chaineFormeVersCode(buffer2.readLine());
            int mem_inst = Integer.parseInt(buffer2.readLine());
            int mem_max = Integer.parseInt(buffer2.readLine());
            newCarteMere[i] = new CarteMere(forme, mem_inst, mem_max);
        }
        buffer2.close();
        reader2.close();
    } catch ( FileNotFoundException e ) {
        System.out.println( e.getMessage() );
    } catch ( IOException e ) {
        System.out.println( e.getMessage() );
    }

    return newCarteMere;
}