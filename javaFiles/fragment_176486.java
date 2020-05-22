public class RessourceManager {

    private final Map<Class, Renderer> renderers;

    public <T> void registerRenderer(Class<T> objclass, Renderer<T> renderer) {
        this.renderers.put(objclass, renderer);
    }

    @SuppressWarnings("unchecked")
    public void render(Graphics2D g, Object object) {
        Class objclass = object.getClass();
        if(this.renderers.get(objclass) != null) {
            this.renderers.get(objclass).render(g, object); 
        }
    }

}