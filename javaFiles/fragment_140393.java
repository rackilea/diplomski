int x, y, xScreen, yScreen, xNum, yNum;
    Button[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point   size    = new Point();
        display.getSize(size);
        xScreen = size.x;
        yScreen = size.y;
        xNum = 3;
        yNum = 2;

        RelativeLayout gameLayout = (RelativeLayout)     findViewById(R.id.gameLayout);
        x = xScreen / xNum;
        y = (int) (yScreen * 0.2);
        // y = yScreen / yNum - 20;

        RelativeLayout.LayoutParams lp       = null;
        int                         id       =     getResources().getIdentifier("buttons_w2", "drawable", getPackageName());
        ImageView                   gameLogo = new ImageView(this);
        RelativeLayout.LayoutParams imagelp  = new     RelativeLayout.LayoutParams(yScreen, 100);
        gameLogo.setImageResource(id);
        gameLogo.setId(123456);
        gameLayout.addView(gameLogo, imagelp);

        array = new Button[xNum * yNum];

        // Row (=j) first, then column. Reflected in createId
        for (int j = 0; j < yNum; ++j) {
            for (int i = 0; i < xNum; ++i) {
                lp = new RelativeLayout.LayoutParams(x, y);

                int index = (j * xNum) + i;
                int indexToLeft = (j * xNum) + (i - 1);
                int indexToTop = ((j - 1) * xNum) + i;
                int bid = createId(i, j);

                array[index] = new Button(this);
                array[index].setId(bid);

                if (j == 0) {
                    lp.addRule(RelativeLayout.BELOW, gameLogo.getId());
                } else {
                    lp.addRule(RelativeLayout.BELOW, array[indexToTop].getId());
                }

                if (i == 0) {
                    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                } else {
                    lp.addRule(RelativeLayout.RIGHT_OF, array[indexToLeft].getId());
                }

                gameLayout.addView(array[index], lp);
            }
        }
    }

    public int createId(int i, int j) {
        // Add 1 to each index value copied to this function, since the generated ID might
        // evaluate to 0, which is an invalid id!
        i += 1;
        j += 1;

        if (String.valueOf(i).length() == 1 && String.valueOf(j).length() == 1) {
            return Integer.parseInt(String.format("0%d0%d", j, i));
        } else if (String.valueOf(i).length() == 1) {
            return Integer.parseInt(String.format("0%d%d", j, i));
        } else if (String.valueOf(j).length() == 1) {
            return Integer.parseInt(String.format("%d0%d", j, i));
        } else {
            return Integer.parseInt(String.format("%d%d", j, i));
        } 
    }