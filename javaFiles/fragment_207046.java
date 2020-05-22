public void replacing(int[] trans) throws IOException {
    File fp = new File("ciphertext1.txt");
    BufferedReader in = new BufferedReader(new FileReader(fp));
    char[] s = {'e', 't', 'a', 'o', 'i', 'h', 's', 'n', 'd', 'r',
                'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b',
                'v', 'k', 'j', 'x', 'q', 'z'};
    String line;
    while ((line = in.readLine()) != null) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < line.length(); ++i ){
            char c = line.charAt(i);
            if( 'a' <= c && c <= 'z' ){
                sb.append( s[trans[c-'a']] );
            } else {
                  sb.append( c );
            }
        }
        System.out.println( sb.toString() );
    }
    in.close();
}