public interface IPrintable {
    void print();
}

public class PerfGauge implements IMetric, IPrintable {

    public PerfGauge(String name, final Object gaugeSource) {

    }
    public void print() {
         System.out.println("Hello");
    }
}