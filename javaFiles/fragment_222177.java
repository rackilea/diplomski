private View windowView;
private Button clickMe;
private int[colors];

colors=new int[]{Color.CYAN, Color.GREEN, Color.RED};

final int[] finalColors = colors;
final View finalWindowView = windowView;

for (int i = 0; i < finalColors.length; i++) {
    Random random = new Random();

    final int randomNum = random.nextInt(finalColors.length);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            // Do after 500ms
            finalWindowView.setBackgroundColor(colors[randomNum]);
        }
    }, 500 * i);

}