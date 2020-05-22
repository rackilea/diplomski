Bundle bundle = getIntent().getExtras();
if ( bundle != null && bundle.containsKey(key) ) {
    value = bundle.getInt(key); // not nessecarily getInt(), you should use according to your value type
    // use the value to tell if it is from your own app
} else {
    // it is not from your own app
}