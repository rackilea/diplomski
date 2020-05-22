//      File file = new File("ecryption.pdf");
//      System.out.println(file.getAbsolutePath());
//      System.out.println("user.dir is: " + System.getProperty("user.dir"));

// FileInputStream fis   = new FileInputStream(new File("ecrypted.pdf"));
InputStream fis = getAssets().open("ecryption.pdf");

// FileOutputStream fos  = new FileOutputStream(new File("decrypted.pdf"));
FileOutputStream fos  = new FileOutputStream(
       new File(Environment.getExternalStorageDirectory(), "decrypted.pdf"));