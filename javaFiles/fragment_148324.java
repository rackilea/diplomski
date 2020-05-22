MimeMultipart mp = new MimeMultipart();
            MimeBodyPart body = new MimeBodyPart();
            body.setText(allLines_html, "iso-8859-1", "html");
            mp.addBodyPart(body);

            MimeBodyPart attachPart = new MimeBodyPart();
            File attachement = new File("E:\\car_failed_report\\failed.xls");
            if (attachement.exists()) {
                attachPart.attachFile(attachement);
                mp.addBodyPart(attachPart);
            } else {
                System.out.println("ERROR READING THE FILE");
                throw new FileNotFoundException();
            }
            message.setContent(mp);