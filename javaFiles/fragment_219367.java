public PlayerAi(Player player, FieldOfView fov) {
        super(); // this call "father" constructor
        this.player = player;
        this.player.setCreatureAi(this);
        this.fov = fov;
}