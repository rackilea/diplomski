public Class PresenterImpl implements Presenter {

private ViewImpl view;
private Instance<ViewImpl> instanceView;
private User user;

@Inject
public PresenterImpl(Instance<ViewImpl> instanceView, User user) {
   this.instanceView = instanceView;
   this.user = user;

   bind();
}

public void bind() {
   this.view = instanceView.get();
}

public void fetchNames() {
   fetchFromDB();
   view.setUser(user);
}
}