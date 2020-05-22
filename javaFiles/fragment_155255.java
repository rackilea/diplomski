import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetTraders2 {

    private String getTraderLegalName;
    private String businessName;
    private Object status;

    public GetTraders2(String getTraderLegalName, String businessName, String status) {
        this.getTraderLegalName=getTraderLegalName;
        this.businessName=businessName;
        this.status=status;
    }

    @Override
    public String toString() {
        return "GetTraders [getTraderLegalName=" + getTraderLegalName + ", businessName=" + businessName + ", status=" + status + "]";
    }

    public static void main(String[] args) {

        GetTraders2 getTraders1 = new GetTraders2("1", "bn", "status");
        GetTraders2 getTraders2 = new GetTraders2("2", "bn", "status");
        GetTraders2 getTraders3 = new GetTraders2("3", "bn", "status");

        List<GetTraders2> list = new ArrayList<>();
        list.add(getTraders3);
        list.add(getTraders2);
        list.add(getTraders1);

        System.out.println(list);

        Collections.sort(list, new Comparator<GetTraders2>() {

            @Override
            public int compare(GetTraders2 o1, GetTraders2 o2) {
                return o1.getTraderLegalName.compareTo(o2.getTraderLegalName);
            }

        });

        System.out.println(list);

    }

}