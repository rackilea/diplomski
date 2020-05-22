File path = getExternalFilesDir(Environment.DIRECTORY_PICTURES+"/eVendeur");

 if (!dossier.exists()){
    dossier.mkdir();
 }

 File root = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File cachePath = new
        File(root.getAbsolutePath()+"/eVendeur/"+"id_produit"+".jpg");