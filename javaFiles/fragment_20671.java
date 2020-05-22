HtmlExporter exporter = new HtmlExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
exporter.setExporterOutput(new SimpleHtmlExporterOutput("html/my.html"));
SimpleHtmlExporterConfiguration configuration = new SimpleHtmlExporterConfiguration();
configuration.setHtmlHeader(
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
        "<html>\r\n" + 
        "<head>\r\n" + 
        "  <title></title>\r\n" + 
        "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n" + 
        "  <style type=\"text/css\">\r\n" + 
        "    a {text-decoration: none}\r\n" + 
        "   .jrPage {width:90% !important}\r\n" +
        "  </style>\r\n" + 
        "</head>\r\n" + 
        "<body text=\"#000000\" link=\"#000000\" alink=\"#000000\" vlink=\"#000000\">\r\n" + 
        "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
        "<tr><td width=\"5%\">&nbsp;</td><td align=\"center\">\r\n");

configuration.setHtmlFooter(
        "</td><td width=\"5%\">&nbsp;</td></tr>\r\n" + 
        "</table>\r\n" + 
        "</body>\r\n" + 
        "</html>\r\n");
exporter.setConfiguration(configuration);
exporter.exportReport();