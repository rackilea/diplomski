private static SomeActivityUiBinder uiBinder = GWT
        .create(SomeActivityUiBinder.class);

interface SomeActivityUiBinder extends UiBinder<Widget, SomeActivity> {
}

private AcceptsOneWidget display;

public SomeActivity() {
    initWidget(uiBinder.createAndBindUi(this));
}

@Override
public String mayStop() {
    return null;
}

@Override
public void onCancel() {
    onStop();

}

@Override
public void onStop() {
    this.display.setWidget(null);
}

@Override
public void start(AcceptsOneWidget panel, EventBus eventBus) {
    this.display = panel;
    this.display.setWidget(this);
}

}


<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g="urn:import:com.google.gwt.user.client.ui">
   <g:HTMLPanel>
    Hello world!
   </g:HTMLPanel>
</ui:UiBinder>