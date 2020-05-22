public class getset
{


    static BluetoothSocket sock;

    getset(BluetoothSocket sock)
    {
        this.sock=sock;
    }


    public static synchronized BluetoothSocket getSock() {
        return sock;
    }

    public static synchronized void setSock(BluetoothSocket sock) {
        getset.sock = sock;
    }
}