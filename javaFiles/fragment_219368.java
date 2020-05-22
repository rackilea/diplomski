public PlayerAi(Player player, FieldOfView fov) {
            super(//??creature); // you have to pass something here
            this.player = player;
            this.player.setCreatureAi(this);
            this.fov = fov;
    }