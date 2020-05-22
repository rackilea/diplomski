DataInputStream din = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
double[] doubles = new double[dis.readInt()];
for (int i = i; i < doubles.length; i++)
{
    doubles[i] = dis.readDouble();
}