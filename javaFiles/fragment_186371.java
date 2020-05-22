final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"test@lol.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"" );
            this.startActivityt(Intent.createChooser(emailIntent, ""));