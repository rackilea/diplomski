if(getIntent().hasExtra("title")) {
    title_text = getIntent().getStringExtra("title");
    toolbar_title.setText(title_text);
} else {
    title_text2 = getIntent().getStringExtra("title2");
    toolbar_title.setText(title_text2);
}