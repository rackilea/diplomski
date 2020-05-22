public String getUrlForArtist(String artistName) {
        SharedPreferences settings = mContext.getSharedPreferences(
                "artistImages", 0);
        return settings.getString(artistName, "http://default.url");
    }

public void setUrlForArtist(String artistName, String url) {
        SharedPreferences settings = mContext.getSharedPreferences(
                "artistImages", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(artistName, url);
        editor.commit();
}