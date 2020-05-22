import org.apache.commons.digester.*;

public class MyApp {
    public static void digestItemsDetails(Digester digester, String root) {
        String itemTag = root;
        digester.addObjectCreate(itemTag, Item.class);
        /* snip */
        String billingPrefix = itemTag  + "/billingDetails";
        digester.addObjectCreate(billingPrefix, BillingDetails.class);
        digester.addCallMethod(billingPrefix +"/billFrequency", "setBillFrequency", 0);
        digester.addCallMethod(billingPrefix +"/billingCycle", "setBillingCycle", 0);
        digester.addSetNext(billingPrefix, "setBillingDetails");
        /* snip */
    }
}