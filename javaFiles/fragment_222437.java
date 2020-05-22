@Override
public void onResponse(JSONObject response) {

    try {
        String usname = response.optString("username");
        String usid = response.optString("user_id");
        String correct = response.optString("correct");

        if(usid.contains("1")) {
            Intent intent = new Intent(getApplicationContext(), SelectorActivity.class);

            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Login ou Mot de passe Incorrecte",Toast.LENGTH_SHORT).show();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}