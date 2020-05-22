for (int i = 0; i < parachuters.size(); i++)
    {
    if (parachuters.get(i).getY() > canvas.getHeight()) {
        parachuters.remove(i);
        onPlaySound();
        checkLivesLeftValue();
    } else if(parachuters.get(i).isDead) {
        parachuters.remove(i);
    }