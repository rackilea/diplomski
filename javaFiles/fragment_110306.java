public void loadPlayers() {
    // LinearLayout lv = (LinearLayout) findViewById(R.id.player_list);
    TextView tv;

    for (int i = 0; i < Game.getPlayers().length; i++) {
        tv = new TextView(getActivity());
        tv.setText(String.valueOf(Game.getPlayers()[i].getName()));
        tv.setPadding(8, 8, 8, 8);
        tv.setTextSize(20);
        tv.setBackgroundColor(0xD0D0D0);

        lv.addView(tv);
    }
}