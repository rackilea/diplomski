if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Request does not contain upload data");
            writer.flush();
            return;
        }
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);

        ServletFileUpload upload = new ServletFileUpload(factory);
        //upload.setFileSizeMax(MAX_FILE_SIZE);
        //upload.setSizeMax(MAX_REQUEST_SIZE);

        String uuidValue = "";
        FileItem itemFile = null;

        try {
            // parses the request's content to extract file data
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();

            // iterates over form's fields to get UUID Value
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equalsIgnoreCase(UUID_STRING)) {
                        uuidValue = item.getString();
                    }
                }
                // processes only fields that are not form fields
                if (!item.isFormField()) {
                    itemFile = item;
                }
            }
            System.out.println("no of items: " + formItems.size());
            System.out.println("FILE NAME IS : "+itemFile.getName());
    }
}