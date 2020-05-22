if (result.trim().equalsIgnoreCase(OK_)) {
    Toast.makeText(getApplicationContext(),
                   "Connected",
                   Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(getApplicationContext(),
                   "Error"+result,
                   Toast.LENGTH_LONG).show();
}