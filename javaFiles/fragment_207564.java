audio2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent audio_intent = new Intent(getApplicationContext(), AudioPopup.class);
        audio_intent.putExtra("lesson_res_id", R.raw.lesson2-2);
        startActivity(audio_intent);

    }
});