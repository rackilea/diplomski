public class VisibilityManager {
    public static void hide(View view){
        view.setVisibility(View.GONE); 
    }

    public static void show(View view){
        view.setVisibility(View.VISIBLE); 
    }
}