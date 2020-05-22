// 0 == floor, 1 == wall, 2 == different looking wall
int[][] maze = {
        {0, 0, 0, 0, 0},
        {0, 1, 2, 1, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 2, 1, 0},
        {0, 0, 0, 0, 0}
};

Bitmap[] bitmaps = {
        BitmapFactory.decodeResource(getResources(), R.drawable.floor),
        BitmapFactory.decodeResource(getResources(), R.drawable.firstwall)
        BitmapFactory.decodeResource(getResources(), R.drawable.secondwall)
};

// Chance the 480 and 320 to match the screen size of your device
maze = new Maze(bitmaps, maze, 5, 5, 480, 320);