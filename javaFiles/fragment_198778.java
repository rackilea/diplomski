public void testSoundPLayer() throws Exception {

Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
for(int i = 0; i < mixerInfo.length; i++)
{
    AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(Constants.SOUND_ALERT));

    Mixer.Info info = mixerInfo[i];

    System.out.println(String.format("Name [%s] \n Description [%s]\n\n", info.getName(), info.getDescription()));
    System.out.println(info.getDescription());

    try
    {
        Clip clip = AudioSystem.getClip(info);
        clip.open(inputStream);
        clip.start();
    }
    catch (Throwable t)
    {
        System.out.println(t.toString());
    }
    Thread.sleep(2000L);
}