public void updateTotalPlayTime(Context ctx, String value){
        SharedPreferences sp = ctx.getSharedPreferences("TotalPlaybackTime", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("totalPlayTime", value);
        editor.commit();
 }