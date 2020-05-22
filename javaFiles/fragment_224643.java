public class TestClass {
static class ResourceA implements AutoCloseable{
      public void read() throws Exception{
        throw new Exception("ResourceA read exception");
      }
      @Override
      public void close() throws Exception {
        throw new Exception("ResourceA close exception");
      }
    };

static class ResourceB implements AutoCloseable{
      public void read() throws Exception{
        throw new Exception("ResourceB read exception");
      }
      @Override
      public void close() throws Exception {
        throw new Exception("ResourceB close exception");
      }
    };

    //a test method
    public static void test() throws Exception{
      try (ResourceA a = new ResourceA();
           //ResourceB b = new ResourceB()
              ) {
        a.read();
        //b.read();
      } catch (Exception e) {
        throw e;
      }
    }

    public static void main(String[] args)  throws Exception {
        test();
    }