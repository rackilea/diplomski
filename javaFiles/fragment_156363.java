public class HomePage extends AbstractPage {

    private By dropdownDate = By.id("date");
    private By dropdownMonth = By.id("month");
    private By dropdownYear = By.id("year");

    public HomePage selectDate(final LocalDate date) {
        selectByVisibleText(dropdownMonth, date.getMonthValue());
        selectByVisibleText(dropdownDate, date.getDayOfMonth());
        selectByVisibleText(dropdownYear, date.getYear());
        return this;
    }
}