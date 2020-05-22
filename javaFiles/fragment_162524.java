MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
StringBuffer sb = new StringBuffer("<html><body>");
for (int a= 0; a<=i; a++){
        System.out.println("nameArrays.get(a) -"+nameArrays.get(a));
        sb.append("<h2>"+nameArrays.get(a)+"</h2>");
    }

sb.append("</body></html>");