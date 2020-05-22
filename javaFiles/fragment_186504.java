public class SwitchColor{
    private TextView view;
    private int colorIndex;
    private String initialColor;
    private String finalColor;

    public SwitchColor(TextView view, int colorIndex, String initialColor,   String finalColor) {
        this.view = view;
        this.colorIndex = colorIndex;
        this.initialColor = initialColor;
        this.finalColor = finalColor;
        SwitchTextViewBackground();//Change is here
    }

    public void SwitchTextViewBackground(){

        if(colorIndex <= 10 && colorIndex < 0) {
            view.setBackgroundColor(Color.parseColor(initialColor));
        } else {
            //if (colorIndex <= 90 && colorIndex <=100){ 
            if (colorIndex >= 90 && colorIndex <=100){//Here is an edit
                view.setBackgroundColor(Color.parseColor(finalColor));
            }
            else {
                Random rnd = new Random();
                int color = Color.argb(rnd.nextInt(256), rnd.nextInt(256),     rnd.nextInt(256), rnd.nextInt(256));
                view.setBackgroundColor(color);
            }
        }
    }
}