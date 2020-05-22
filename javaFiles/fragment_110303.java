public void loadPlayers() {
    LinearLayout lv = (LinearLayout) findViewById(R.id.player_list);
        // R.id.player_list is not inside activity_main.xml
        // lv is null

    ...

    lv.addView(tv[i]); // NullPointerException                 
    }
}