public class Manager {

        private static Map<Class<? extends Manager>,Manager> INSTANCES_MAP = new java.util.HashMap<Class<? extends Manager>, Manager>();

//Also, you will want to make this method synchronized if your application is multithreaded,
//otherwise you mihgt have a race condition in which multiple threads will trick it into
//creating multiple instances
        public static <E extends Manager> E getInstance(Class<E> instanceClass) throws InstantiationException, IllegalAccessException {
            if(INSTANCES_MAP.containsKey(instanceClass)) {
                return (E) INSTANCES_MAP.get(instanceClass);
            } else {
                E instance = instanceClass.newInstance();
                INSTANCES_MAP.put(instanceClass, instance);
                return instance;
            }
        }
    }