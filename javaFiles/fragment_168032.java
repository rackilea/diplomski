String str = "ABC";
List<byte[][]> codedString = new ArrayList<byte[][]>();

for ( char c : str.toCharArray() ) {

    switch ( c ) {

        case 'A':
            codedString.add( new byte[][]{
                { 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0 } } );
            break;

        case 'B':
            codedString.add( new byte[][]{
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 0 } } );
            break;

        case 'C':
            codedString.add( new byte[][]{
                { 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 0 } } );
            break;

    }

}

for ( byte[][] codedChar : codedString ) {
    for ( int i = 0; i < codedChar.length; i++ ) {
        for ( int j = 0; j < codedChar[i].length; j++ ) {
            System.out.print( codedChar[i][j] == 1 ? "X" : " " );
        }
        System.out.println();
    }
}