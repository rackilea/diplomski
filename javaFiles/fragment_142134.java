Intent email = new Intent(Intent.ACTION_SEND);
              email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
              //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
              //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
              email.putExtra(Intent.EXTRA_SUBJECT, "subject");
              email.putExtra(Intent.EXTRA_TEXT, "message");

              //need this to prompts email client only
              email.setType("message/rfc822");

              startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }