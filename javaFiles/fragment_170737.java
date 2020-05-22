private CLOB createClobFromStringStreaming(String xml, Connection conn) throws SQLException, IOException {
        CLOB clob = CLOB.createTemporary(conn, false, CLOB.DURATION_SESSION);       
        BufferedReader br = new BufferedReader(new StringReader(xml));
        char[] buffer = new char[1024/*clob.getChunkSize()*/];
        int read = 0;
        Writer w = clob.setCharacterStream(0L);
        try {
            for (read = br.read(buffer); read > -1; read = br.read(buffer)) {
                w.write(buffer, 0, read);
                w.flush();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                w.flush();
                w.close();
                br.close();
            } catch (IOException e1) {
                throw e1;
            }
        }

        return clob;
    }