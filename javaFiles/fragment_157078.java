public abstract class UserCommonPage<T extends UserContentComponent> extends CommonPage<T>{

    @Inject
    protected UserNavBarComponent userNavBar;

    public UserNavBarComponent getUserNavBar() {
        return userNavBar;
    }

    @PageShown
    public void preparePageShown() {
        log.debug("Page shown");
        userNavBar.refresh();
    }
}

public class UserContentComponent extends ContentComponent{
   ...
}