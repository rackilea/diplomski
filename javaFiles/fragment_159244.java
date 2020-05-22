if (address ==null || address.isEmpty()) {
   Toast.makeText(getApplicationContext(), "wrong address",
        Toast.LENGTH_LONG).show();
} else {
    locationtest = address.get(0);
    ....