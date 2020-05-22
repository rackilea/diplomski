@RequestMapping("/downloadFile")
       public void downloadFile(HttpServletRequest request, HttpServletResponse response) {             

       try {

            String fileName = "C:/excelFile.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("firstSheet");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Address");
            rowhead.createCell(3).setCellValue("Email");

            HSSFRow row = sheet.createRow((short) 1);
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("Carlos");
            row.createCell(2).setCellValue("Costa Rica");
            row.createCell(3).setCellValue("myNameh@gmail.com");

            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");

            //Code to download
            File fileToDownload = new File(fileName);
            InputStream in = new FileInputStream(fileToDownload);

            // Gets MIME type of the file
            String mimeType = new MimetypesFileTypeMap().getContentType(fileName);

            if (mimeType == null) {
                // Set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            System.out.println("MIME type: " + mimeType);

            // Modifies response
            response.setContentType(mimeType);
            response.setContentLength((int) fileToDownload.length());

            // Forces download
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileToDownload.getName());
            response.setHeader(headerKey, headerValue);

            // obtains response's output stream
            OutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = in.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            in.close();
            outStream.close();

            System.out.println("File downloaded at client successfully");


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }