while ((imageBytes = socketChannel.read(imgbuf)) > 0)
{
    imgbuf.flip(); // prepare for reading

    fileChannel.write(imgbuf); // write to temp file

    imgbuf.clear(); // prepare for next block
}