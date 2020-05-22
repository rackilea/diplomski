BufferedReader br = new BufferedReader(
        new InputStreamReader(
                new ByteArrayInputStream(
                        new byte[]{(byte) 0x0, (byte) 0x0, 'H', 'i', '\n'}
                )));
String line = br.readLine();
System.out.println("line.length()=" + line.length());
System.out.println(line);