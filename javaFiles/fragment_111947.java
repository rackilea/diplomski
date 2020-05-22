//we can set it to 2 as we know that there are 2 calls
    private int semafor = 2;
    private Intent returnIntent= new Intent(DialogActivity.this, MainActivity.class);


void parsAndSendTheAudiDbBiography(String response) {
    try {
        Gson gson = new Gson();
        TheaudiodbBiography theaudiodbBiography = gson.fromJson(response, TheaudiodbBiography.class);

        returnIntent.putExtra("artistThumb", checkNullable(theaudiodbBiography.getArtists()
                .get(0).getStrArtistThumb()));
        semafor --;
        if (semafor == 0) {
            finish();
        }

    } catch (Exception e) {

        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}

 void parseAndShowOneMusicBio(String response) {
    try {
        Gson gson = new Gson();
        OneMusicBiography[] oneMusicBio = gson.fromJson(response, OneMusicBiography[].class);

        returnIntent.putExtra("aliases", oneMusicBio[0].getAliases().toString());

        semafor --;
        if (semafor == 0) {
            finish();
        }

    } catch (Exception e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
    }
}