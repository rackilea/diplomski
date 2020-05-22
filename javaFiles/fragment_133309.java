InputStream is = connection.getInputStream();
InputStreamReader reader = new InputStreamReader(is);
            StringBuilder builder = new StringBuilder();
            int c = 0;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }