response.setContentType("application/vnd.ms-excel");
    PrintWriter out = response.getWriter();
    try {
            out.println("\tId \tName");
            out.println("\t1\tabc");
            out.println("\t2\txyz");
            out.println("\t3\tpqr");
    } finally {
        out.close();
    }