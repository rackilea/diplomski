public class MyMidiPlaybackListener implements MidiPlaybackListener
{
    public void onPlaybackComplete()
    {
        // Since onPlaybackComplete is likely called by a worker thread
        // And we don't want to update the GUI from a worker thread
        // (because that would violate Swing's threading policy)
        // we update the GUI via a SwingUtilities.invokeLater Runnable
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                myButton.setSelected(true);
            }
        });
    }
}