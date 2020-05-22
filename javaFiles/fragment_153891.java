StringBuilder sb = new StringBuilder();

sb.append("<ArrayOfString>");
sb.append("<string>").sb.append("the_command").sb.append("</string>");
sb.append("</ArrayOfString>");

StringEntity entity = new StringEntity(sb.toString(), "UTF-8");
httppost.setEntity(entity);  
httppost.addHeader("Accept", "application/xml");
httppost.addHeader("Content-Type", "application/xml");

HttpResponse response = httpclient.execute(httppost);