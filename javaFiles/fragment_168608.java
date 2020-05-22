int counter = 0;


onCreate(...){
    SharedPreferences countPref = getSharedPreferences("Counter", Context.MODE_PRIVATE);
    counter = countPref.getInt("count", 0);
}

mBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        counter++;
        SharedPreferences countPref = getSharedPreferences("Counter", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorOpenClose = countPref.edit();
        editorOpenClose.putInt("count", counter);
        editorOpenClose.apply();


        if (counter>3){
        Toast.makeText(c, "success!", Toast.LENGTH_SHORT).show();
        }

    }
});