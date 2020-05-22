MultipartRequest cr = new MultipartRequest();
    cr.setUrl("http://localhost/PIDEV/web/app_dev.php/Api/produit/ajout");
    cr.setPost(true);
    String mime = "image/png";
    try {
        cr.addData("file", filePath, mime);
    } catch (IOException e) {
        e.printStackTrace();
    }
    String fichernom = System.currentTimeMillis() + ".png";
    cr.setFilename("file", fichernom);

    InfiniteProgress prog = new InfiniteProgress();
    Dialog dlg = prog.showInifiniteBlocking();
    cr.setDisposeOnCompletion(dlg);
    NetworkManager.getInstance().addToQueueAndWait(cr);