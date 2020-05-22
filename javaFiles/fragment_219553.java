public int[] toIntArray(byte[] barr) { 
        //Pad the size to multiple of 4 
        int size = (barr.length / 4) + ((barr.length % 4 == 0) ? 0 : 1);       

        ByteBuffer bb = ByteBuffer.allocate(size *4); 
        bb.put(barr); 

        //Java uses Big Endian. Network program uses Little Endian. 
        bb.order(ByteOrder.BIG_ENDIAN); 
        bb.rewind(); 
        IntBuffer ib =  bb.asIntBuffer();         
        int [] result = new int [size]; 
        ib.get(result); 


        return result; 
}