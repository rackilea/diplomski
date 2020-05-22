import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetTraders1 implements Comparable<GetTraders1> {

    private String getTraderLegalName;
    private String businessName;
    private Object status;

    public GetTraders1(String getTraderLegalName, String businessName, String status) {
        this.getTraderLegalName=getTraderLegalName;
        this.businessName=businessName;
        this.status=status;
    }

    @Override
    public int compareTo(GetTraders1 that) {
        return this.getTraderLegalName.compareTo(that.getTraderLegalName);
    }

    @Override
    public String toString() {
        return "GetTraders [getTraderLegalName=" + getTraderLegalName + ", businessName=" + businessName + ", status=" + status + "]";
    }

    public static void main(String[] args) {

        GetTraders1 getTraders1 = new GetTraders1("1", "bn", "status");
        GetTraders1 getTraders2 = new GetTraders1("2", "bn", "status");
        GetTraders1 getTraders3 = new GetTraders1("3", "bn", "status");

        List<GetTraders1> list = new ArrayList<>();
        list.add(getTraders3);
        list.add(getTraders2);
        list.add(getTraders1);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

    }

}