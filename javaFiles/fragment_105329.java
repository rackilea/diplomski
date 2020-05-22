public class StartBeforeEndDateValidator implements ConstraintValidator<StartBeforeEndDateValid, StartEndDatable> {

    @Override
    public void initialize(StartBeforeEndDateValid annotation) {
    }

    @Override
    public boolean isValid(StartEndDatable bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getStartDate();
        final LocalDate endDate = bean.getEndDate();

        return !startDate.isAfter(endDate);
    }
}