String[] buttonids = getResources().getStringArray(R.array.buttonids);
for (String buttonid : buttonids) {
    final String name = buttonid;
    int id = getResources().getIdentifier(name, "id", getPackageName());
    Button button = findViewById(id);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            audiotoplay = name;
            playAudio(audiotoplay);
        }
    });
}