@RequestMapping(value = "/getcsv", method = RequestMethod.GET)
    public void getCSV(HttpServletResponse response){

        String csv = "a,b";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "fileName.csv");
        response.setHeader("Access-Control-Expose-Headers","Authorization, Content-Disposition");
        try (PrintWriter pw = new PrintWriter(response.getOutputStream())) {
            pw.write(csv);
        }
    }