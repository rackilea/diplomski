public void printNumericPyramid( final int depth, final String alignment, final String orientation ) {
    final List<String> l1 = new ArrayList<String>();
    for (int i = 0, c = 0; i < depth; i++) {
        final StringBuilder sb = new StringBuilder();
        for (int j = 0; j < depth; j++) {
            sb.append( j >= depth - (i + 1) ? c++ : "." );
        }
        l1.add("left".equals(alignment) ? sb.reverse().toString() : sb.toString());
    }
    if ( "inverted".equals(orientation) ) Collections.reverse(l1);

    for ( final String s : l1 ) {
        System.out.println( s );
    }
}