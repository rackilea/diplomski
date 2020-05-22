/* User: koray@tugay.biz Date: 21/02/15 Time: 21:18 */

import java.io.IOException;

public class MyTestClass {

    public static void main(String[] args) throws IOException {
        MyConnectionAccepter myConnectionAccepter = new MyConnectionAccepter();
        myConnectionAccepter.start();
    }
}