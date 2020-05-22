public class MyView extends View {

public MyView(Context context) {
    super(context);
    Drawable d = context.getDrawable(R.drawable.ic_launcher_background);
    getDrawable(R.drawable.ic_launcher_background);  //without context IDE will give error cannot resolve getDrawable(int).
    }
}