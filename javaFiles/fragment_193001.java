final Player player;
try(FileInputStream fis = new FileInputStream("*FILE*")){
    player = new Player(fis);
} catch(JavaLayerException | IOException e){
    e.printStackTrace();

    // prevent access to uninitialized player variable by exiting the method
    throw new RuntimeException(e);
}

Button btn = new Button();
btn.setText("Start");
Button btn2 = new Button();
btn2.setText("Stop");

btn.setOnAction((ActionEvent event) -> {
    this.player = player;
    try{
        new playMusic(player).start();
    } catch(Exception e){
        e.printStackTrace();
    }
});

btn2.setOnAction((ActionEvent event)->{
    player.close();
});