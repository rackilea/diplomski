static final Font defaultFont =new Font( "Arial Unicode MS", Font.BOLD, 48 );

static private Font[] allFonts;

static final char sampleChineseCharacter = '\u4F60';  // ni3 as in ni3 hao3

public static void loadFonts() {

    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

    allFonts = env.getAllFonts();
    int nFonts = allFonts != null ? allFonts.length : 0;
    fontNames = new String[nFonts];
    fontMap = new Hashtable();
    String currentFamily = "";
    int j = 0;

    for ( int i = 0; i < nFonts; i++ ) {

        Font font = allFonts[ i ];

        System.out.println( allFonts[ i ] );

        if ( font.canDisplay( sampleChineseCharacter )) {

                currentFamily = font.getFamily();

                Object key = fontMap.put( currentFamily, font );

                if ( key == null ) {

                    // The currentFamily hasn't been seen yet.

                    fontNames[ j ] = currentFamily;
                    j++;

                }

        }

    }

    String tmp[] = fontNames;
    fontNames = new String[j];
    System.arraycopy( tmp, 0, fontNames, 0, j );

}