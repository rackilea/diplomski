title    = title.replaceAll("\"", "''");
        desc_val = desc_val.replaceAll("\"","''");

        title = strutil.escapeHtml(title);
        desc_val = strutil.escapeHtml(desc_val);
        url_val = strutil.escapeHtml(url_val);