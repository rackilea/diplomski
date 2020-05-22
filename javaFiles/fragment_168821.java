public int read(byte[] b,
                int off,
                int len)
         throws IOException {
    innerInputStream.read(b,off,len);
}


InputStreamDecorator d = new InputStreamDecorator(new FileInputStream("myfile.txt"));