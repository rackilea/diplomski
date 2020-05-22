Bundle bundle = getArguments();
        int itemCount = bundle.getInt("itemCount",0);
        if(itemCount > 0){
            for (int i = 0; i < itemCount ; i++) {
              String language =  bundle.getString(TEXT+"i");
            }
        }