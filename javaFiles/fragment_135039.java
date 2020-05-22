public class ChartColorSource {
    public static final Color[] COLORS;
    static {
        COLORS = new Color[ 6 ];
        COLORS[0] = new Color( ... );
        COLORS[1] = new Color( ... );
        COLORS[2] = new Color( ... );
        COLORS[3] = new Color( ... );
        COLORS[4] = new Color( ... );
        COLORS[5] = new Color( ... );
    }

    /**
     * Assign a color from the standard ones to each category
     */
    public static void colorChart( Plot plot, String[] categories ) {
        if ( categories.length > COLORS.length ) {
            // More categories than colors. Do something!
            return;
        }

        // Use the standard colors as a list so we can shuffle it and get 
        // a different order each time.
        List<Color> myColors = Arrays.asList( COLORS );
        Collections.shuffle( myColors );

        for ( int i = 0; i < categories.length; i++ ) {
            plot.setSectionPaint( categories[i], myColors.get( i ) );
        }
    }
}