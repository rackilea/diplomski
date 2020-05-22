public static void main(String[] args) throws IOException, UnknownHostException
{
    Socket socket;

            //  #'s are what I got from whatismyip.org on the server computer)
    byte[] serverb = new byte[] {(byte)##, (byte)##, (byte)###, (byte)###};

    socket = new Socket(InetAddress.getByAddress(serverb),31350);
}