String[][] conversionMatrix = {{"K", "1000"}, {"M", "1000000"}, {"B", "1000000000"}};

for( int i = 0; i < conversionMatrix.length; i++)
{
    if( yviews.endsWith( conversionMatrix[i][0]))
    {
        BigDecimal temp = new BigDecimal( yviews.substring( 0, 
                                            yviews.indexOf( conversionMatrix[i][0])));
        temp = temp.multiply( new BigDecimal( conversionMatrix[i][1]));
        yviews = temp.toBigInteger().toString();
        break;
    }
}

System.out.println( yviews);