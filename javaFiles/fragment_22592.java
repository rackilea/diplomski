protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 

                 String responseSend = "";

            String from = request.getParameter("n1");
            String to = request.getParameter("n2");    

              if ((from == null) || (from.equals(""))) {

                System.out.println("From null");
                responseSend = "error";

            } 
              else if ((to == null) || (to.equals(""))) {

                System.out.println("End null");
               responseSend  = "error";

            }
              else{            
                      //jdbc code              
            System.out.println("got it");
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));
            responseSend = "code";           
              }

             out.print(responseSend);

        }          
            }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           System.out.println("In get");
            processRequest(request, response);
    }