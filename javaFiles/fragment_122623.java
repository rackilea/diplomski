public class IndexComposer
    extends SelectorComposer<Component>
{
    public IndexComposer()
    {
        EventQueues.lookup("MyEventQueueName", EventQueues.APPLICATION, true)
                   .subscribe(e -> {
                       String data = (String) e.getData();
                       // update your UI element
                   });
    }

    @Listen("onClick = #btn")
    public void button()
    {
        Window win = (Window) Executions.createComponents("popup.zul", getSelf().getParent(), null);
        win.doModal();
    }
}

public class PopupComposer
    extends SelectorComposer<Component>
{
    @Wire
    private Window  popupWindow;

    @Wire
    private Textbox txt;

    @Listen("onClick = #close")
    public void closePopup()
    {
        popupWindow.detach();
        EventQueues.lookup("MyEventQueueName", EventQueues.APPLICATION, true)
                   .publish(new Event("", null, txt.getValue()));
    }
}