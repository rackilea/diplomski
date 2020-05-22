SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

int defaultValue = getResources().getInteger(R.integer.mutecounterkeydefault);    
int mutecounter = sharedPref.getInt(getString(R.string.mutecounterkey), defaultValue);

ImageButton mutebb = (ImageButton) findViewById(R.id.muteb);

if (mutecounter == 1) {
    mutebb.setImageResource(R.mipmap.muteon);
}

mutebb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        MediaPlayerPool.mute = !MediaPlayerPool.mute;

        SharedPreferences.Editor editor = sharedPref.edit();

        if (mutecounter == 0) {
            mutebb.setImageResource(R.mipmap.muteon);
            mutecounter = 1;


            editor.putInt(getString(R.string.mutecounterkey), mutecounter);

        } else {
            mutebb.setImageResource(R.mipmap.muteoff);
            mutecounter = 0;

            editor.putInt(getString(R.string.mutecounterkey), mutecounter);
        }

        editor.apply();
    }
});