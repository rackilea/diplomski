Random rnd = new Random();
for(int c=0; i<grid.getChildCount();i++){
    int bg = vector[ rnd.nextInt(vector.length) ];

    grid.getChildAt(c).setBackgroundResource(bg);
}