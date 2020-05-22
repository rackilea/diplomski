public abstract class A {

    private Function fetchData; // product to be used

    public class A() {
        fetchData = createFunction(); // call factory method
    }

    protected abstract Function createFunction(); // factory method

    // precondition: fetchData != null
    public Object generateData(AbstractForm form) {
        List<DataBean> dataBeans = fetchData.apply(form); // using the product
        return null; // whatever you want to return
    }

}