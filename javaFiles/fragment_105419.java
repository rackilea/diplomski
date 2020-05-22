public void onResume() {
    super.onResume();

    SomeObject object = new SomeObject();

    object.setSuccessListener(new EventListener<Boolean>() {
        public void onEvent(Boolean response) {
            Log.d(TAG_NAME, "Valid response? "+response);
        }
    });

    SomeObjectManager.getSingleton().addObject(object);
}