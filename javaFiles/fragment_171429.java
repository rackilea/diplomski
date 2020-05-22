final String nick = NICKNAME_EXIST;
checkDataRegistrationByServer(nick, new CallSoap.AsyncResponse() {

    @Override
    public void processFinish(String response) {
        Log.d("Response From AsyncTask:", output);
        boolean exists = !response.equals(FALSE_RESPONSE);
        if (!exists) {
            Toast.makeText(getApplicationContext(), output + " - NickNameExistCall - Nick " + nick + " doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }
});