public Clip loadClip( String filename )
{
    Clip in = null;

    try
    {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream( getClass().getResource( filename ) );
        in = AudioSystem.getClip();
        in.open( audioIn );
    }
    catch( Exception e )
    {
        e.printStackTrace();
    }

    return in;
}