return commonMethod(urlString, payload, new ConnectionWorker() {
        @Override
        public void run(HttpURLConnection connection) throws IOException {
            // UNIQUE CODE START
            CallHandler.this.prepareConnection(connection, POST);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            // UNIQUE CODE END
        }
    });