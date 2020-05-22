protected void attachBaseContext(Context base) {
    if (this.value) {
        // Your special behavior
        super.attachBaseContext(ZeTarget.attachBaseContext(base,this));
    } else {
        // The super's behavior, as though you hadn't overridden the method
        super.attachBaseContext(base);
    }
}