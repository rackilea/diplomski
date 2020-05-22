for (int i = 0; i < ex.getExpenses().size(); i++) {
        out.println("<td>" + ex.getExpenses().get(i) + "</td>");
        if (i>0 && i%4==0) {
            out.println("</tr><tr>");
        }
    }