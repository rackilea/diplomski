public class A {

    private Function fetchData; // strategy

    public void setStrategy(Function fetchData) { // method for setting the strategy
        this.fetchData = fetchData;
    }

    // precondition: fetchData != null
    public Object generateData(AbstractForm form) {
        List<DataBean> dataBeans = fetchData.apply(form); // using the strategy
        return null; // whatever you want to return
    }    
}