void updateImpl() {
    if(health <= 0) {
        dead = true;
        isEnabled = false;
    }
    if(dead) fireDeathEvent();
}