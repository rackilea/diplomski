public class LocalizedDateEditor extends CustomDateEditor {

    public LocalizedDateEditor(FormatHelper formatHelper) {
        super(new SimpleDateFormat(formatHelper.getDefaultDateFormat()), true);
    }
}