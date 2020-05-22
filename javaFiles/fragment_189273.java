try {
        url = new URL(urlFichierATelecharger);
        myCon = url.openConnection();
        myCon.setRequestProperty("Cookie", cookieCible);
        contentDisposition = myCon.getHeaderField("Content-Disposition");
        if (!contentDisposition.contains("attachment;filename=")) {
            assertTrue(false, "The link isn't a download link.");
        }
    } catch [...]