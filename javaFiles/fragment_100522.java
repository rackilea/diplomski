//....
        email.putExtra(Intent.EXTRA_STREAM, uri);
        //....
        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));