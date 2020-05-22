public class TestBase <T extends BasePage> {

    private T currentPage;

    public T getCurrentPage() {
        return currentPage;
    }

    public void setBasePage(T page) {
        currentPage = page;
    }

}