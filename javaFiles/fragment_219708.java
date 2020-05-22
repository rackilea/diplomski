if (code.contains("#")){
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+Uri.encode(code))); //here add Uri.encode
            context.startActivity(i);
        }