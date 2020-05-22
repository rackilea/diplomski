public class mainMenu implements Scene {

    ResourceManager resourceManager;

    public mainMenu(ResourceManager resourceManager){

        this.resourceManager = resourceManager;
    }

    @Override
    public void render(){

        resourceManager.render(this);
    }

    @Override
    public void updateLogic(){

        resourceManager.updateLogic(this);
    }

}