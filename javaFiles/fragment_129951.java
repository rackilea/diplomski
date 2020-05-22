try {
        val shareIntent = Intent(android.content.Intent.ACTION_SEND)
        val appPackageName = applicationContext.packageName
        val strAppLink = "https://play.google.com/store/apps/details?id=$appPackageName"
        shareIntent.type = "text/plain"
        val shareSub = "Hey Download this App Called\n Appname ........\nAt least One Time Try This\n"
        val data = shareSub + strAppLink
        //shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub)
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, data)
        startActivity(Intent.createChooser(shareIntent, "Share using"))
    } catch (e: ActivityNotFoundException) {

    }