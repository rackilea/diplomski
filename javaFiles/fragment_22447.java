if( inputStream.hasNextInt() )
{
    try
    {
        dur = inputStream.nextInt();
        freq = inputStream.nextInt();
        System.out.println( dur );
        System.out.println( freq );
        if( dur > -1 && freq > -1 )
        {
            finch.setLED( Color.GREEN );
            finch.playTone( freq, dur );
        }
    }
    catch( InputMismatchException exception )
    {
        // do exception handling
    }
}