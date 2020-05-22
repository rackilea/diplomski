boolean authorized = false;

   if (currentUser != null) {
        if (currentUser.getType().equals("BUYER")) {
            for (String s : access.getBuyer().getPages()) {
                if (pageRequested.contains(s)) {
                    authorized = true;
                    break;
                }
            }
        } else if (currentUser.getType().equals("SELLER")) {
            for (String s : access.getSeller().getPages()) {
                if (pageRequested.contains(s)) {
                    authorized = true;
                    break;
                }
            }
        } else if (currentUser.getType().equals("ADMINISTRATOR")) {
            for (String s : access.getAdministrator().getPages()) {
                if (pageRequested.contains(s)) {
                    authorized = true;
                    break;
                }
            }
        }
    }

    if (authorized) {
        chain.doFilter(request, response);
    } else {
        resp.sendRedirect("main.xhtml");
    }