public class NavigationUtils{
public static void navigate(Context source, Class<?> destination){
            Intent intent = new Intent(source, destination);
            source.startActivity(intent);
        }
}