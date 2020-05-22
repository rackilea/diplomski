import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassTypeAdapterTest {
    @Test
    public void testReadWrite() {
        final Class<?> classToWrite = ClassTypeAdapter.class;

        final Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassTypeAdapter()).create();

        final String writtenClass = gson.toJson(classToWrite);
        final Class readClass = gson.fromJson(writtenClass, Class.class);

        assertEquals(classToWrite, readClass);
    }

    @Test
    public void testInnerClassProblem() {
        final Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassTypeAdapter()).create();

        final TestClass testClass = new TestClass<>();
        testClass.innerClass = Object.class;

        final String writtenClass = gson.toJson(testClass);
        final TestClass readClass = gson.fromJson(writtenClass, TestClass.class);

        assertEquals(testClass.innerClass, readClass.innerClass);
    }

    private static class TestClass<T> {
        private Class<T> innerClass;
    }
}