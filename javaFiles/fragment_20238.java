public String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {
    Reader reader = new InputStreamReader(new BufferedInputStream(stream), "UTF-8");

    char[] readBuffer = new char[4096];// 4KB

    StringBuilder resultado = new StringBuilder();

    int readLen;

    while ((readLen = reader.read(readBuffer)) != -1) {

        resultado.append(readBuffer, 0, readLen);

    }

    System.out.println(resultado);

    return resultado.toString();
}