public class UnitTest implements IDatabase {

    @Override
    public returnValue insert(yourParam) {
        // Here can you test your statement and manipulate the return value
        return null;
    }

    @Override
    public int update(yourParam){
        if (yourParam.containsValue(value1)) {
          assertEquals("yourStatement", yourParam);
          return 1;
        }else if (yourParam.containsValue(value2)) {
          assertEquals("yourStatement2", yourParam);
          return 5;
        }else{
           assertTrue(false,"unknown Statement")
        }
    }

    @Test
    public void yourTest(){
       RealClass.setDbInstance(this);
        //Test something
    }        
}