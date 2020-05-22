public class Search {

    private Desktop desktop = new Desktop();
    BrowserWindow win;

    @Before
    public void baseState() {
        BrowserBaseState baseState = new BrowserBaseState("silk4j.settings");
        win = baseState.execute(desktop).find("//BrowserWindow");
    }

    @Test
    public void searchNames() {
        win.<DomButton>find("//INPUT[@id='edit-submit']").select();
    }
}