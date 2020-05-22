try (FileInputStream fis = new FileInputStream(mp3FileName))
{
    Player player = new Player(fis);
    player.play();
} catch (IOException | JavaLayerException e) {
    e.printStackTrace();
}