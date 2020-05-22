try {
        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        final String appPackageName = getApplicationContext().getPackageName();
        String strAppLink = "https://play.google.com/store/apps/details?id=" + appPackageName;
        shareIntent.setType("text/plain");
        String shareBody = strAppLink;
        String shareSub = "Hey Download this App Called\n Appname ........\nAt least One Time Try This\n";
        String data = shareSub + shareBody
        // shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, data);
        startActivity(Intent.createChooser(shareIntent, "Share using"));
    } catch (ActivityNotFoundException e) {

    }