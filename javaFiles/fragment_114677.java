if(getServletContext().getAttribute("oldConnector") == null){
            getServletContext().setAttribute("oldConnector", "old value");//dummy value added, replace it with your connection object.
            System.out.println("oldConnector attribute has be set.");
        }else{
            getServletContext().removeAttribute("oldConnector");
            System.out.println("oldConnector attribute has be removed");
        }