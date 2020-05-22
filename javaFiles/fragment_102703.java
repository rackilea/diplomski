//This is the updated constructor from the BrowserWindow class
public BrowserWindow(int _w, int _h){
        width = _w;
        height = _h;

        //imgData = ByteBuffer.allocate(width * height * 4 * Integer.BYTES); This is the old line that created a non-direct ByteBuffer.
        imgData = ByteBuffer.allocateDirect(width * height * 4);//This is the new line. Note the allocateDirect() call and the removal of the extra space in the buffer in the form of Integer.BYTES.
        texture = new PreloadedTexture(width, height);
    }