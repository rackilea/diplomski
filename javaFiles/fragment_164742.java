email.append("<html><body>"
                    + "<table style='border:2px solid black'>");

        update.setString(1, "Outstanding");
        ResultSet results = update.executeQuery();

        while (results.next()) {
            System.out.println("in results...");
            email.append("<tr bgcolor=\"#33CC99\">");
            email.append("<td>");
            long period = results.getLong("period_to");
            email.append(DateConvert.fromEpoch(period));
            email.append("</td>");

            email.append("<td>");
            email.append(results.getString("type"));
            email.append("</td>");

            email.append("<td>");
            email.append(results.getString("amt"));
            email.append("</td>");

            email.append("<td>");
            email.append(results.getString("status"));
            email.append("</td>");

            email.append("<tr>");
        }

        email.append("</table></body></html>");
        sm.populateMailMessage(email.toString());
        sm.sendMail();