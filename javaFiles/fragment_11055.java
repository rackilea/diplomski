package com.my.package;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.AbstractComponent;
public class VideoPreloadExtension extends AbstractExtension {

    public VideoPreloadExtension() {
    }

    public VideoPreloadExtension(AbstractClientConnector target) {
        super(target);
    }

    public void extend(AbstractComponent component) {
        super.extend(component);
    }

}