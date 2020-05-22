public class TestClassImpl extends CommonTestParent {

    private CommonTestParameter testParam;

    @Override
    protected CommonTestParameter getTestParameter(){
        return this.testParam;
    }

    @DataProvider(name = "awesomeDataProvider")
    public static Iterator<Object[]> provideData(){
        List<Object[]> dataList = new LinkedList<Object[]>();
        dataList.add(new TestParameterImpl("Stuff1!", "More stuff1!"));
        dataList.add(new TestParameterImpl("Stuff2!", "More stuff2!"));
        return dataList.iterator();
    }

    @Factory(dataProvider = "awesomeDataProvider")
    public TestClassImpl(CommonTestParameter aTestParam){
        this.testParam = aTestParam;
    }

    @Test
    public void testStuff(){
        System.out.println(this.testParam.getStuff());
    }

    @Test
    public void testMoreStuff(){
        System.out.println(this.testParam.getMoreStuff().toString());
    }
}