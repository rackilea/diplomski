public class EventDecorator implements DayViewDecorator {

    private final Drawable drawable;
    private final CalendarDay day;
    private final int color;

    public EventDecorator(MaterialCalendarView view, Date date, int color) {
        this.day = CalendarDay.from(date);
        this.color = color;
        this.drawable = createTintedDrawable(view.getContext(), color);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        if (this.day.equals(day)) {
            return true;
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }

    private static Drawable createTintedDrawable(Context context, int color) {
        return applyTint(createBaseDrawable(context), color);
    }

    private static Drawable applyTint(Drawable drawable, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    private static Drawable createBaseDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.day);
    }
}