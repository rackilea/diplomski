public void musicconfig ()
{
    try
    {
        if (mutestate == false)
        {
            AudioPlayer.player.stop (as);
            InputStream in = new FileInputStream (filename [count]);
            as = new AudioStream (in);
            AudioPlayer.player.start (as);
        }
    }

    catch (IOException b)
    {
        b.printStackTrace ();
    }
    count++;

    if (count == 12)
    {
        count = 1;
    }
}