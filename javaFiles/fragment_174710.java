boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart)
        {
            try 
            {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) 
                {
                    FileItem item = (FileItem) iterator.next();

                    if (item.isFormField()) //your code for getting form fields
                    {
                        String name = item.getFieldName();
                        String value = item.getString();
                        System.out.println(name+value);
                    }

                    if (!item.isFormField()) 
                    {
                       //your code for getting multipart 
                    }
                }
            }