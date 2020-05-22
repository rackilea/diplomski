import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

RootPanel.get().addDomHandler(new ClickHandler() {

    @Override
    public void onClick(ClickEvent event) {
        System.out.println("Click");

    }
}, ClickEvent.getType());