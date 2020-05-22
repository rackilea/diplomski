IntBuffer intBuffer = ByteBuffer.wrap(this.byteOut.toByteArray()).asIntBuffer();
while (intBuffer.hasRemaining()){
    intStreamBuilder.accept(intBuffer.get());
}
int[] pool = intStreamBuilder.build().toArray();
super.lock(pool);