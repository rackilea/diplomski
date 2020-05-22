protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        String filename = (String) request.getAttribute("fileName");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment;filename="+filename);

        File file = new File(filename);
        FileInputStream fileIn = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();

        byte[] outputByte = new byte[(int)file.length()];
        //copy binary contect to output stream
        while(fileIn.read(outputByte, 0, (int)file.length()) != -1)
        {
        out.write(outputByte, 0, (int)file.length());
        }
     }