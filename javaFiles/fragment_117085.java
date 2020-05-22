package source.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UiHandlerTest implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel.getBodyElement().appendChild(new TheHandlerTest("My Button").getElement());

    }

}