public class HelloUiBinder implements EntryPoint {
 public void onModuleLoad() {
 MyDockLayoutPanel mydocklayoutpanel = new MyDockLayoutPanel    ("able","baker","charlie");
 mydocklayoutpanel.addWidget(new BrowserPanel());
 RootPanel.get().add(mydocklayoutpanel);
 }