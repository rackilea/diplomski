import com.siebel.data.SiebelException;
    import com.siebel.data.SiebelPropertySet;
    import com.siebel.data.SiebelService;

    public class BasicDataBeanTest {
    public static void main(String[] args) throws SiebelException {

        SiebelDataBean dataBean = new SiebelDataBean();
        dataBean.login("siebel://mymachine:2321/siebel/SCCObjMgr_enu", "USER", "PWD", "enu");

        SiebelService businessService = dataBean.getService("Workflow Utilities");
        SiebelPropertySet input = new SiebelPropertySet();
        SiebelPropertySet output = new SiebelPropertySet();
        input.setValue("Please echo this");

        businessService.invokeMethod("Echo", input, output);

        System.out.println("Output: " + output.toString());
    }

}