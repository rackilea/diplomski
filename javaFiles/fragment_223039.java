SharedPreferences lala = 
            getSharedPreferences("eu.drgekko.rftoolz_preferences", Context.MODE_PRIVATE);

    if (lala.getBoolean("OneColors", true)){
        this.mQwertyKeyboard = new EmojiKeyboard(this, R.xml.qwertycolor);

    } else {
        this.mQwertyKeyboard = new EmojiKeyboard(this, R.xml.qwerty);

    }