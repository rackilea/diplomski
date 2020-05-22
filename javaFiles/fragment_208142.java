public class DateFormatterServerResource extends ServerResource {
    @Post
    public String formatDate(long time) {
        return DateFormatter.getFormatedDate(new Date(time));
    }
}