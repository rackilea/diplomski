public class SalaryRangeValidator implements ConstraintValidator<ValidateSalaryRange, SalaryRange> {

    @Override public void initialize(ValidateSalaryRange date) {}

    @Override
    public boolean isValid(SalaryRange range, ConstraintValidatorContext ctx) {
        return range.getMinSalary() < range.getMaxSalary();
    }
}