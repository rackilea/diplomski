public abstract class GameObject implements Serializable, IClusterable {
    private static final long serialVersionUID = 1L;

    public String name;
    private boolean activatable;
    private boolean obstacle;

    public GameObject(String name, boolean activatable, boolean obstacle) {
        super();
        this.name = name;
        this.activatable = activatable;
        this.obstacle = obstacle;
    }

    public abstract void doButtonOneActivity();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivatable() {
        return activatable;
    }

    public void setActivatable(boolean activatable) {
        this.activatable = activatable;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }
}