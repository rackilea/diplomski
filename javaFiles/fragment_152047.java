imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // What is the purpose of this line?
        Bundle b = mVideos.get(numero).getAsBundle();
        Bundle a = new Bundle();
        a.putParcelableArrayList("videos", mVideos);
        // Replace YourNewActivity with the name of the Activity you want to start.
        Intent i = new Intent(dAct, YourNewActivity.class);
        i.putExtra("description", b);
        i.putExtra("videos", a); // I added it to intent
        dAct.startActivity(i);
    }
});