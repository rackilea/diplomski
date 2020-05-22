public void collided_in_to(Entity ent) {

    if(ent.equals(game.player)) {
        if(this.timer.isExpired()) this.speak = "";
        else this.speak = "Ouch!";
    }
}