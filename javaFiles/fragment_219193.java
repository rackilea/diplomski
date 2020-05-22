InputStream a = new InputStream(){
    @Override
    public int read() throws IOException {
        return System.in.read();
    }
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int r=0;
        do {
            int x=read();
            if(x<0) return r==0? -1: r;
            b[off++]=(byte)x;
            r++;
        } while(r<len && System.in.available()>0);
        return r;
    }
};
BufferedReader reader = new BufferedReader(new InputStreamReader(a));
return reader.readLine();