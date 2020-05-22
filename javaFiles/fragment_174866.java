public class UploadComponentConnector extends UploadConnector {
    UploadServerRpc rpc = RpcProxy.create(UploadServerRpc.class, this);
    public UploadComponentConnector() {
        getWidget().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                rpc.clicked(getWidget().getNotificationName());
            }
        });
    }
}