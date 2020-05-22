public class PermissionUtils {
public static final int REQUEST_EXTERNAL_STORAGE = 2000;

        public static void requestExternal(Activity context) {
        if (!checkExternal(context)) {
            ActivityCompat.requestPermissions(context, new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

      public static boolean checkExternal(Context context) {
        return !(ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED);
    }

}