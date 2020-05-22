ItemColor1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v){
        Toast.makeText(activity, "Couleur mise à jour", Toast.LENGTH_SHORT).show();
        currentTheme = position;

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("indexColorSelected", currentTheme);
        editor.apply();

        // Here, you send the proper drawable...
        // I'm not sure how you convert color selected to the drawable
        // So, add your logic to convert the button clicked to a drawable here
        // like R.drawable.user_color1
        chatAdapter.setColor(R.drawable.NAME_OF_THE_COLOR);

        // Request to re-draw all items from the list (all bubbles)
        chatAdapter.notifyDataSetChanged();
    }
});