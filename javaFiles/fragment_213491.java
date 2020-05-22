public class ModalWindowBean {
    ...

    public void enableContentRendering(String clientId, String windowId) {
        UIComponent component = FacesContext.getCurrentInstance().getViewRoot().findComponent(clientId + ":" + windowId);
        component.getAttributes().put("contentRenderingEnabled", true);
    }
}