String uid = "";
        String name = "";
        String display = "";
        String email = "";
        String pw = "";
        String created = "";
        String updated = "";

        if(c.has(TAG_ID))
           uid = c.getString(TAG_ID);

        if(c.has(TAG_NAME))
           name = c.getString(TAG_NAME);

        if(c.has(TAG_DISPLAY))
           display = c.getString(TAG_DISPLAY);

        if(c.has(TAG_EMAIL))
           email = c.getString(TAG_EMAIL);

        if(c.has(TAG_PW))
           pw = c.getString(TAG_PW);

        if(c.has(TAG_CREATED))
           created = c.getString(TAG_CREATED);

        if(c.has(TAG_UPDATED))
           updated = c.getString(TAG_UPDATED);