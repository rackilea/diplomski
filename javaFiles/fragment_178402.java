jokesButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openContentPage(0);
    }
});

 poemsButton .setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         openContentPage(1);
     }
 });

 funnyStoriesButton .setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         openContentPage(2);
     }
 });

private void openContentPage(int v) {
    if(v == 0) {
        Intent intentContentPage = new Intent(MainActivity.this, Content.class);
        intent.putExtra("keyPage",0);
        startActivity(intentContentPage);
    }
    else if(v == 1) {
        Intent intentContentPage = new Intent(MainActivity.this, Content.class);
        intent.putExtra("keyPage",1);
        startActivity(intentContentPage);
    }
    else {
        Intent intentContentPage = new Intent(MainActivity.this, Content.class);
        intent.putExtra("keyPage",2);
        startActivity(intentContentPage);
    }
}