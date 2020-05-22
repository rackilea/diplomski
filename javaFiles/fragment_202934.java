//Just put Intent on your button click
button.setOnClickListener(new Button.OnClickListener() {
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(course.getCourseurl()));
        mCtx.startActivity(i);
        //This will open url in browser if you have application in your device.
    }
});