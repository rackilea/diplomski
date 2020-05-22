FileInputStream input;
    String result = null;
    try {
        input = new FileInputStream(new File("invalid.txt"));
        CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        decoder.onMalformedInput(CodingErrorAction.IGNORE);
        InputStreamReader reader = new InputStreamReader(input, decoder);
        BufferedReader bufferedReader = new BufferedReader( reader );
        StringBuilder sb = new StringBuilder();
        String line = bufferedReader.readLine();
        while( line != null ) {
            sb.append( line );
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        result = sb.toString();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch( IOException e ) {
        e.printStackTrace();
    }

    System.out.println(result);