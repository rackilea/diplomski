ParseObject object = new ParseObject("ClassName");
    object.getObjectId().toString();

    String str_obj = object.getObjectId().toString();

    Intent i = new Intent();
    i.putExtra("objectId", str_obj);

    // in next screen
    String getObj;
    getObj = getIntent().getStringExtra("objectId");

    ParseObject oo = new ParseObject("ClassName");
    oo.setObjectId(getObj);