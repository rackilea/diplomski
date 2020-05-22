@Dependent
class MyPresenter {

    private MyView view;

    public void setView(MyView view) {
        this.view = view;
    }
}

public interface MyView {
}

@CDIView("my-view")
public class MyViewImpl extends VerticalLayout implements View, MyView {

    @Inject
    private MyPresenter presenter;

    @PostConstruct
    private void init() {
        presenter.setView(this);
    }
}