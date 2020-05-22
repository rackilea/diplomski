for (Cookie c : g) {
        if (c != null) {
            System.out.println(c.getName() + " " + c.getValue());
            if (c.getName().compareTo("tipo") == 0) {
                cookie.setValue(c.getValue());
            }
            if (c.getName().compareTo("usuario") == 0) {
                cuser = c;
            }
        }
    }