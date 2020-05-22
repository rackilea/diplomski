String currentName = "";
    while (event != XmlPullParser.END_DOCUMENT) {
        String name=myParser.getName();
        switch (event){
            case XmlPullParser.START_TAG:
                currentName = name;
                break;
            case XmlPullParser.TEXT:
                if("from".equals(currentName)){
                    value = myParser.getText(); 

                    Log.d(getTag(), "NEZINAU " + value);                        
                    }

                break;


            case XmlPullParser.END_TAG:
                break;
        }