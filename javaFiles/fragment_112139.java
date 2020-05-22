public class ResourceManager {

    private float resourceA = 0;
    private float resourceB = 0;
    private float resourceC = 0;

    public enum ResourceType {

        A {

            @Override
            protected void setResource(ResourceManager manager, float newValue) {
                manager.resourceA = newValue;
            }

            @Override
            protected float getResource(ResourceManager manager) {
                return manager.resourceA;
            }
        }, B {

            @Override
            protected void setResource(ResourceManager manager, float newValue) {
                manager.resourceB = newValue;
            }

            @Override
            protected float getResource(ResourceManager manager) {
                return manager.resourceB;
            }
        }, C {

            @Override
            protected void setResource(ResourceManager manager, float newValue) {
                manager.resourceC = newValue;
            }

            @Override
            protected float getResource(ResourceManager manager) {
                return manager.resourceC;
            }
        };

        protected abstract void setResource(ResourceManager manager, float newValue);

        protected abstract float getResource(ResourceManager manager);
    }

    public void add(ResourceType type, float amount) {
        type.setResource(this, type.getResource(this) + amount);
    }

    public void multiply(ResourceType type, float amount) {
        type.setResource(this, type.getResource(this) * amount);
    }
}