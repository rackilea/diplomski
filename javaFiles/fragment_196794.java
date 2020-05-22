import java.io.*;
import java.util.*;

public class ExecTest {
    public static void main(String[] args) throws IOException {
        Process result = Runtime.getRuntime().exec("traceroute -m 1 www.amazon.com");

        BufferedReader output = new BufferedReader(new InputStreamReader(result.getInputStream()));
        String thisLine = output.readLine();
        StringTokenizer st = new StringTokenizer(thisLine);
        st.nextToken();
        String gateway = st.nextToken();
        System.out.printf("The gateway is %s\n", gateway);
    }
}