InputStream input = connectionSocket.getInputStream();
        OutputStream output = connectionSocket.getOutputStream();

        Request request = null;

        while ((request = Request.parseDelimitedFrom(input)) != null) {
            System.out.println(request.toString());

        }