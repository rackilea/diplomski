int[] colors = {
        ...
        Color.RED, // the 6th color.
        ...
};

Random rand = new Random();
int tag = rand.nextInt((9 - 1) + 1) + 1;

Button button = (Button) findViewByTag(String.valueOf(tag));
button.setBackgroundColor(colors[tag - 1]); // -1 because array start from 0.