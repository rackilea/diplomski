HttpURLConnection connection = null;
       try {
                URL url = new URL("http://stackoverflow.com/");
                connection = (HttpURLConnection) url.openConnection();

                long start = System.currentTimeMillis();
                String jsonResponse = myInputStreamReader(connection.getInputStream());

                long finish = System.currentTimeMillis();
                long totalTime = finish - start;
                System.out.println("Total Time for page load - " + totalTime);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }

    static public String myInputStreamReader(InputStream in) throws IOException {

            StringBuilder sb = null;
            try {
                InputStreamReader reader = new InputStreamReader(in);
                sb = new StringBuilder();
                int c = reader.read();
                while (c != -1) {
                    sb.append((char) c);
                    c = reader.read();
                }
                reader.close();
                return sb.toString();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            return sb.toString();
        }