String user_agent = request.getHeader("user-agent");
            boolean isInternetExplorer = (user_agent.indexOf("MSIE") > -1);
            if (isInternetExplorer) {
                response.setHeader("Content-disposition", "attachment; filename=\"" + URLEncoder.encode(templateName+".cft", "utf-8") + "\"");
            } else {                 
                response.addHeader("Content-Disposition", "attachment; " +"filename=\"" + MimeUtility.encodeWord(templateName+".cft", "utf-8", "Q") + "\"");
            }