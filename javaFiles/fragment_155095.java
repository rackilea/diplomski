DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
dos.writeInt(doubles.length); // send the array length
for (d : doubles)
{
    dos.writeDouble(d);
}
dos.flush();