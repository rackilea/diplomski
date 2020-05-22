public byte[] toBytes(int... ints){
    Byte[] rv = new Byte[0]
        ints.each{
            rv += (Byte[]) ByteBuffer.allocate(4).putInt(it).array()
        }

        return rv
}

assert toBytes(1,2,3) == ([0,0,0,1,0,0,0,2,0,0,0,3] as byte[])