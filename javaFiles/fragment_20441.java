public class tester {   
        @Test
        public void test() throws Exception{
        abc a = new abc();
        Assert.assertEquals((int)a.getA(), 0);      
        }
    }