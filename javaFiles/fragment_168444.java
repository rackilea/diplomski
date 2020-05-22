@RequestMapping(value = "download", method=RequestMethod.GET)
        public @ResponseBody void download(HttpServletRequest request, HttpServletResponse response){
            String fileName="/home/test/Testing.xlsx";
            PrintWriter out=null;

            try{
                System.out.println(fileName.substring(fileName.lastIndexOf('/')+1)+"fileName");
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Cache-Control", "must-revalidate");
                response.setHeader( "Pragma", "public" );
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName.substring(fileName.lastIndexOf('/')+1) );
                out = response.getWriter();
                int i;
                FileInputStream inputStream = new FileInputStream(fileName);
                while ((i = inputStream.read()) != -1) {
                    out.write(i);
                }
                inputStream.close();
                out.close();

            }
            catch(Exception e){
                System.out.println(e);
            }


        }