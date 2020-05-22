MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setTo(mail.getTo());
            message.setFrom(mail.getFrom());
            message.setSubject(mail.getSubject());
            message.setText(mail.getText(), mail.getHtml());

            if(StringUtils.isNotBlank(mail.getPdfAttachmentFileName())) {
                File file = new File(uploadDir + "/" + mail.getPdfAttachmentFileName());
                DataSource dataSource = new ByteArrayDataSource(new FileInputStream(file), "application/pdf");
                message.addAttachment(mail.getPdfAttachmentFileName(), dataSource);
            }