lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view,  int position, long id) {

        Home item = (Home) adapter.getItem(position);

        Intent d = new Intent(HomeActivity.this, item.getClazz());
        startActivity(d);

        /** Fading Transition Effect */
        HomeActivity.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
});