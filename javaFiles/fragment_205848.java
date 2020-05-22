import java.util.ArrayList;
import java.util.List;

public class Sandbox
{
    static interface MyInterface
    {
    }

    static interface Storable<T>
    {
        List<T> getInstances();
    };

    static abstract class MyStorableImpl implements MyInterface
    {
        @Override
        public String toString()
        {
            return "I'm a " + getClass() + " with hashcode " + hashCode();
        }
    }

    static class MyStorable1 extends MyStorableImpl
    {
    }

    static class MyStorable2 extends MyStorableImpl
    {
    }

    static class StorageUnit<T extends MyInterface> implements Storable<T>
    {
        private final int count;

        private final Class<T> clazz;

        public StorageUnit(Class<T> clazz, int count)
        {
            this.count = count;
            this.clazz = clazz;
        }

        private List<T> storables = new ArrayList<T>();

        public List<T> getInstances()
        {
            try
            {
                if (storables.size() == 0)
                {
                    for (int i = 0; i < count; i++)
                    {
                        storables.add(clazz.newInstance());
                    }
                }
                else
                {
                    return storables;
                }
            }
            catch (IllegalAccessException illegalAccessException)
            {
                illegalAccessException.printStackTrace();
            }
            catch (InstantiationException instantiationException)
            {
                instantiationException.printStackTrace();
            }

            return storables;
        }
    }

    static class MyStorageUnitContainer
    {

        private List<StorageUnit<? extends MyInterface>> storageUnits;

        public MyStorageUnitContainer(List<StorageUnit<? extends MyInterface>> storageUnits)
        {
            this.storageUnits = storageUnits;
        }

        public List<MyInterface> getAllInstances()
        {
            List<MyInterface> instances = new ArrayList<MyInterface>();
            for (StorageUnit<? extends MyInterface> storageUnit : storageUnits)
            {
                List<? extends MyInterface> list = storageUnit.getInstances();
                instances.addAll(list);
            }
            return instances;
        }
    }

    public static void main(String[] args)
    {
        StorageUnit<? extends MyInterface> box1 = new StorageUnit<MyStorable1>(MyStorable1.class, 2);
        StorageUnit<? extends MyInterface> box2 = new StorageUnit<MyStorable2>(MyStorable2.class, 3);
        List<StorageUnit<? extends MyInterface>> boxes = new ArrayList<Sandbox.StorageUnit<? extends MyInterface>>();
        boxes.add(box1);
        boxes.add(box2);

        MyStorageUnitContainer container = new MyStorageUnitContainer(boxes);
        List<MyInterface> allInstances = container.getAllInstances();
        for (MyInterface myInterface : allInstances)
        {
            System.out.println(myInterface.toString());
        }
    }

}