public class PlayerFactoryBean implements FactoryBean<Player> {

    private String name;
    private Shoes shoes;

    public void setName(String name) {
        this.name = name;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    @Override
    public Player getObject() throws Exception {
        //initialization logic goes here
        System.out.println("Creating bean using factory");
        return new Player(name, shoes);
    }

    @Override
    public Class<Player> getObjectType() {
        return Player.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}