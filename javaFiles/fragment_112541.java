public void Update() {
        Draw();
        CheckPickUp();
    }
    public void CheckPickUp(){
        if(Canvas.isColliding(Game.p.getX(), Game.p.getY(), Game.p.getX() + 32, Game.p.getY() - 32, x, y));
        System.out.println("Colliding");
        this.ToBag();
    }

    public void ToBag() {
        Inventory i = null;
        i = Game.p.getI();
        Game.world.getItems().remove(this);
        i.getInventory().add(new BagItem(type, i, tex, texturefactor, durability, power));
    }