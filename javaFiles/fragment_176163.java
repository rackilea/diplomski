/**
     * default values.
     */
    if (Settings.isRegistered(this)) {
        Intent i = new Intent(this, Register.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(i);
    }