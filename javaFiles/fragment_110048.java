DownloadManager mgr = (DownloadManager) this.getSystemService(Context.DOWNLOAD_SERVICE);

           String uRl = "http://bitsparrow.altervista.org/wp-content/uploads/2013/04/5.jpg";
        Uri downloadUri = Uri.parse(uRl);
           DownloadManager.Request request = new DownloadManager.Request(
                   downloadUri);

           request.setAllowedNetworkTypes(
                   DownloadManager.Request.NETWORK_WIFI
                           | DownloadManager.Request.NETWORK_MOBILE)
                   .setAllowedOverRoaming(false).setTitle("Demo")
                   .setDescription("Something useful. No, really.")
                   .setDestinationInExternalPublicDir("/.appimg", "test.jpg");

           mgr.enqueue(request);