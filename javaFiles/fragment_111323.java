ByteBuffer bb = ByteBuffer.allocateDirect(100);
for(int i =0;i< 100; i++) {
  bb.put((byte)i);
}
ByteBuffer tt = ByteBuffer.allocateDirect(100);
// reset the position so that we can copy it to the new ByteBuffer.
// Could also call bb.rewind() here. 
bb.position(0);
tt.put(bb);

for(int i =0;i< 100; i++) {
       System.out.println("BACKED bb" + bb.get(i));
       System.out.println("BACKED tt" + tt.get(i));
}