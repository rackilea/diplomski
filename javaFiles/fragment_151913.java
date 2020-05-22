public void playClip( Clip clip )
{
    if( clip.isRunning() ) clip.stop();
            clip.setFramePosition( 0 );
    clip.start();
}