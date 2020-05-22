public class PresentOrFutureValidator
        implements ConstraintValidator<PresentOrFuture, Date> {

        public final void initialize(final PresentOrFuture annotation) {}

        public final boolean isValid(final Date value,
            final ConstraintValidatorContext context) {

            // Only use the date for comparison
            Calendar calendar = Calendar.getInstance(); 
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);

            Date today = calendar.getTime();

            // Your date must be after today or today (== not before today)
            return !value.before(today) || value.after(today);

        }
    }