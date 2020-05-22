public abstract class BaseModels implements Models {

    protected static <T extends Models> T instance(Class<T> type, T candidate) {
        if (candidate == null) {
            try {
                candidate = type.newInstance();
                candidate.load();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return candidate;
    }
}