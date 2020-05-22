String splitedemail[]=new String[5];
 for(int i=0;i<splitedemail.length;i++) {
                s4 = text3.getText().toString();
                splitedemail=s4.split(",");
            }
 for( i=0;i<splitedemail.length;i++) {
        toArr[i] = splitedemail[i]; 
        String arr[] = {toArr[i]};
        m.setTo(arr);
        m.setFrom("abhishek.roychoudhury69@gmail.com");
        m.setSubject(s3);
        m.setBody(message);

        try {
            m.addAttachment(path);

            if (m.send()) {
                Toast.makeText(context, "Email was sent successfully :)", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Email was not sent :(", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            //Toast.makeText(context, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            Log.e("MailApp", "Could not send email", e);
        }

    }