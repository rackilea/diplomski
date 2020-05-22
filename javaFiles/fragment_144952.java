SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

int isVisible = sharedPreferences.getInt("cv1", View.GONE);
cv1.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv2", View.GONE);
cv2.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv3", View.GONE);
cv3.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv4", View.GONE);
cv4.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv5", View.GONE);
cv5.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv6", View.GONE);
cv6.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv7", View.GONE);
cv7.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv8", View.GONE);
cv8.setVisibility(isVisible);
isVisible = sharedPreferences.getInt("cv9", View.GONE);
cv9.setVisibility(isVisible);

AddBar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        clickcount = clickcount + 1;

        if (clickcount == 1) {

            cv1.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv1", View.VISIBLE).commit();
        }

        if (clickcount == 2) {
            cv2.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv2", View.VISIBLE).commit();
        }

        if (clickcount == 3) {
            cv3.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv3", View.VISIBLE).commit();
        }

        if (clickcount == 4) {
            cv4.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv4", View.VISIBLE).commit();
        }

        if (clickcount == 5) {
            cv5.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv5", View.VISIBLE).commit();
        }

        if (clickcount == 6) {
            cv6.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv6", View.VISIBLE).commit();
        }

        if (clickcount==7 ){
            cv7.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv7", View.VISIBLE).commit();
        }
    }
});

AddVoorraad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        clickcountV=clickcountV+1;

        if (clickcountV==1) {
            cv8.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv8", View.VISIBLE).commit();
        }

        if (clickcountV==2) {
            cv9.setVisibility(View.VISIBLE);
            sharedPreferences.edit().putInt("cv9", View.VISIBLE).commit();
        }

    }
});