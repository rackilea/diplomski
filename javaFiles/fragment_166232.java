File file =  new File("data.txt");

FileChannel fileChannel = new RandomAccessFile(file, "r").getChannel();

MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

List<Edge> edges= new ArrayList<Edge>();

while(buffer.hasRemaining())
{
    Edge e = new Edge();
    e.X1 = buffer.getDouble();
    e.Y1 = buffer.getDouble();
    e.X2 = buffer.getDouble();
    e.Y2 = buffer.getDouble();
    // here you will need to set the color Object first !!
    // e.color.setHue(buffer.getDouble());

    edges.add(e);

}