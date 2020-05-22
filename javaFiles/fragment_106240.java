out.println("<html>");
out.println("<head>\n"
        + "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
        + "<script>\n"
        + "$(function() {\n"
        + "  $('input[type=\"checkbox\"]')\n"
        + "    .on('change', function(){$('input[type=\"checkbox\"]').not(this).prop('checked', false);});\n"
        + "});\n"
        + "</script>\n"
        + "</head>");
out.println("<body>");