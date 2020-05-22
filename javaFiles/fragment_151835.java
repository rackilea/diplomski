byte[] buffer = new byte[4096];

try ( InputStream input = rs.getBinaryStream("FILE");
      OutputStream output = response.getOutputStream() ) {

    int numRead = 0;

    while ( ( numRead = input.read( buffer ) ) != -1 ) {
        output.write(buffer, 0, numRead );
    }

}