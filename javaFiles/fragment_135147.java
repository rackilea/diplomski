public class PresenterUtils extends Utils {

    private Context context;

    public PresenterUtils(Context context) {
        this.context = context;
    }

    public String getDateFormat() {
        return context.getResources().getString(R.string.date_format);
    }
}