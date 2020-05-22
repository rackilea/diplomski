DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE); // sets maximum size of request (include file + form data)
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        System.out.println("item.getFieldName() => "+item.getFieldName());
                        String fileAttr[] = fileName.split("\\.");
                        String newFileName = fileAttr[0];
                        int i = 1;
                        while (true) {
                            File f = new File(uploadPath + "\\" + newFileName + "." + fileAttr[1]);
                            if (f.exists()) {
                                newFileName = fileAttr[0] + i;
                                i++;
                            } else {
                                fileName = newFileName + "." + fileAttr[1];
                                break;
                            }
                        }
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        request.setAttribute("message","Upload has been done successfully!");
                    } else {
                        System.out.println("1 item.getFieldName() => "+item.getFieldName());
                        if("description1".equalsIgnoreCase(item.getFieldName())){
                            //this part is for other field except file field
                        }
                    }
                }
            }