File f=new File("full image path");
Uri uri = Uri.parse("file://"+f.getAbsolutePath());
Intent share = new Intent(Intent.ACTION_SEND);
share.setPackage("com.whatsapp");
share.putExtra(Intent.EXTRA_STREAM, uri);
share.setType("image/*");
share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
context.startActivity(Intent.createChooser(share, "Share image File"));