import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Himanshu Mishra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String orignalStr = "AB:#:CD:#:EF";
        String[] orignalSplit = orignalStr.split(":#:");


        // Join all Strings in the Array into a Single String, separated by :#:

        System.out.println("Join Strings using separator " + StringUtils.join(orignalSplit, ":#:"));
    }
}