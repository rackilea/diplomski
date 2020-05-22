protected boolean accept() throws IOException {
            String token = new String(termAtt.buffer(), 0 ,termAtt.length());
            if (token.matches("[0-9,.]+")) {
                return false;
            }
            return true;
        }