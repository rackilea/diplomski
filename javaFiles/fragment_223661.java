public class ClientData
{
    private int pod_count;
    private byte proc_id;
    private short client_id;
    private byte text;

    public static void main (String[] args)
    {
        new ClientData().unpack(Long.decode("0x32112321321fdffa"));
    }
    void unpack(long client_data)
    {
        this.pod_count = (int)(client_data & 0xffffffff);
        client_data = client_data >> 32;
        this.proc_id = (byte) (client_data & 0xff);
        client_data = client_data >> 8;
        this.client_id = (short) (client_data & 0xffff);
        client_data = client_data >> 16;
        this.text = (byte) (client_data & 0xff);
    }
}