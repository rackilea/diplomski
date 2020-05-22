private void render(World world) {
    composite_GO.setColor(Color.black);
    composite_GO.fillRect(0, 0, 800, 600);
    composite_GO.drawImage(worldLayer[1], 
                           world.getWorldObject().getXPosition(), 
                           world.getWorldObject().getXPosition(), null);
}