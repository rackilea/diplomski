import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public class PojoTransactionTest
{
    public static class PojoTransaction<T>
    {
        /**
         * This is the original (unmodified) object
         */
        private T source;

        /**
         * This is the object modified by within the transaction
         */
        private T target;

        /**
         * Creates a new transaction for the given source object
         * @param source    Source object to modify transactionally
         */
        public PojoTransaction(T source)
        {
            try
            {
                this.source = source;
                this.target = (T)source.getClass().newInstance(); //Note: this only supports parameterless constructors

                copyState(source, target);
            }
            catch(Exception e)
            {
                throw new RuntimeException("Failed to create PojoTransaction", e);
            }
        }

        /**
         * Copies state (member fields) from object to another
         * @param from      Object to copy from
         * @param to        Object to copy to
         * @throws IllegalAccessException
         */
        private void copyState(T from, T to) throws IllegalAccessException
        {
            //Copy internal state to target, note that this will NOT copy fields from superclasses
            for(Field f : from.getClass().getDeclaredFields())
            {
                f.setAccessible(true);
                f.set(to, f.get(from));
            }
        }

        /**
         * Returns the transaction target object, this is the one you should modify during transaction
         * @return Target object
         */
        public T getTransactionTarget()
        {
            return target;
        }

        /**
         * Copies the changes from target object back to original object
         */
        public void commit()
        {
            try
            {
                copyState(target, source);
            }
            catch(Exception e)
            {
                throw new RuntimeException("Failed to change state of original object", e);
            }
        }
    }

    public static class TestData
    {
        private String strValue = "TEST";
        private int intValue = 1;
        private float floatValue = 3.1415f;

        public String getStrValue()
        {
            return strValue;
        }

        public void setStrValue(String strValue)
        {
            this.strValue = strValue;
        }

        public int getIntValue()
        {
            return intValue;
        }

        public void setIntValue(int intValue)
        {
            this.intValue = intValue;
        }

        public float getFloatValue()
        {
            return floatValue;
        }

        public void setFloatValue(float floatValue)
        {
            this.floatValue = floatValue;
        }

    }

    @Test
    public void testTransaction()
    {
        //Create some test data
        TestData orig = new TestData();

        //Create transaction for the test data, get the "transaction target"-object from transaction
        PojoTransaction<TestData> tx = new PojoTransaction<TestData>(orig);
        TestData target = tx.getTransactionTarget();
        target.setFloatValue(1.0f);
        target.setIntValue(5);
        target.setStrValue("Another string");

        //Original object is still at the original values
        Assert.assertEquals(1, orig.getIntValue());
        Assert.assertEquals(3.1415f, orig.getFloatValue(), 0.001f);
        Assert.assertEquals("TEST", orig.getStrValue());

        //Commit transaction
        tx.commit();

        //The "orig"-object should now have the changes made to "transaction target"-object
        Assert.assertEquals(5, orig.getIntValue());
        Assert.assertEquals(1.0f, orig.getFloatValue(), 0.001f);
        Assert.assertEquals("Another string", orig.getStrValue());
    }

}