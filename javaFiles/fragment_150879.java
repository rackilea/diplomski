Intent i = new Intent(Intent.ACTION_SEND);
                    i.setPackage("com.whatsapp");
                    i.setType("image/*");
                    i.putExtra(Intent.EXTRA_STREAM, getLocalBitmapUri(context, bitmap, id));
                    i.putExtra(Intent.EXTRA_TEXT, text);
                    context.startActivity(Intent.createChooser(i, "Share News"));