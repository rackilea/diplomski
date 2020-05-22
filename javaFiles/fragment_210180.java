private byte[] serialize() { 
    KryoPool pool = new KryoPool.Builder(factory).softReferences().build();
    Kryo kryo = pool.borrow();
    Output output = new Output(0, 1024);
    kryo.writeClassAndObject(output, readsSetNode);
    byte[] bytes = output.toBytes();
    output.close();
    pool.release(kryo);
    return bytes;
}