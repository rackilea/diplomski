if(Math.abs(animal.getX() - player.getX()) > Math.abs(animal.getY() - player.getY())) {
    //More east-west than north-south - do EAST-WEST check
    if(player.getX() > animal.getX()) {
        animal.setDirection(Direction.EAST);
    } else { 
        animal.setDirection(Direction.WEST);
    }
} else {
     //More north-south than east-west - do NORTH-SOUTH check
    if(player.getY() > animal.getY()) {
        animal.setDirection(Direction.NORTH);
    } else { 
        animal.setDirection(Direction.SOUTH);
    }
}