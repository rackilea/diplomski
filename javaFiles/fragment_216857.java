public String readAll(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String cp;
        while ((cp = br.readLine()) != null) {
            sb.append(cp);
        }
        return sb.toString();
    }