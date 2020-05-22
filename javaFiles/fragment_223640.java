private Frame copyFrame(Frame frame)
{
    // Frame that will hold the copy
    Frame cFrame = new Frame(640, 480, 8, 3);

    // Copy the byte buffer from frame
    ByteBuffer originalByteBuffer = (ByteBuffer) frame.image[0];

    // Create the clone buffer with same capacity as the original
    ByteBuffer cloneBuffer = ByteBuffer.allocateDirect(originalByteBuffer.capacity());
    //ByteBuffer cloneBuffer = deepCopy(originalByteBuffer);

    // Save parameters from the original byte buffer
    int position = originalByteBuffer.position();
    int limit = originalByteBuffer.limit();


    // Set range to the entire buffer
    originalByteBuffer.position(0).limit(originalByteBuffer.capacity());

    // Read from original and put into clone
    cloneBuffer.put(originalByteBuffer);

    // Set the order same as original
    cloneBuffer.order(originalByteBuffer.order());

    // Set clone position to 0 and set the range as the original
    cloneBuffer.position(0);
    cloneBuffer.position(position).limit(limit);

    // Save the clone 
    cFrame.image[0] = cloneBuffer;      

    return cFrame;
}