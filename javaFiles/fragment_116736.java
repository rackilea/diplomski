String idString = request.getParameter("id");
    if(idString != null) {
        try {
            System.out.println(idString.trim()); // print to verify
            int idInt = Integer.parseInt(idString.trim());
        }
        catch(NumberFormatException nbe) {
            nbe.printStackTrace();
        }
    }