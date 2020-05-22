Next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(yes2.isChecked() || no2.isChecked()) {
            Intent intent = new Intent(dengueQues2.this, dengueQues3.class);
            intent.putExtra("REST2", selectedType);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please choose 1 answer", 
                          Toast.LENGTH_SHORT).show();
        }
    }
});