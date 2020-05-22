try{
    Socket s = null;
    try{
    s = new Socket("debian-srv", 2004);
    }catch(UnknownHostException e){
    e.printStackTrace();
    }catch(IOException e){
    e.printStackTrace();
    }
    if (s == null) {
    return -1;
    }


    PyTuple t = new PyTuple(new PyString("Test.brange-debian.mojo"), new PyTuple(new PyInteger(1352975858), new PyInteger(56)));
    PyTuple t2 = new PyTuple(new PyString("Test.brange-debian.mojo"), new PyTuple(new PyInteger(1352975858-60), new PyInteger(43)));
    PyTuple t3 = new PyTuple(new PyString("Test.brange-debian.mojo"), new PyTuple(new PyInteger(1352975858-2*+60), new PyInteger(65)));

    PyList list = new PyList();
    list.append(t);
    list.append(t2);
    list.append(t3);

    PyString payload = cPickle.dumps(list);

    byte[] bytes = ByteBuffer.allocate(4).putInt(payload.__len__()).array();

    s.getOutputStream().write(bytes);
    s.getOutputStream().write(payload.toBytes());
    s.getOutputStream().flush();

    s.close();
}
catch (Exception e) {
    e.printStackTrace();
}