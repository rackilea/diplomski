public void onClick(View view) {

    int[] picture = {
        R.drawable.android3d,R.drawable.android,R.drawable.image1};
        Random r = new Random();
        int n=r.nextInt(7);
        imageView.setImageResource(picture[n]);
}