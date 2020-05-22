package com.my.package.client;

import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.my.package.VideoPreloadExtension;
import com.vaadin.shared.ui.Connect;

@Connect(VideoPreloadExtension.class)
public class VideoPreloadConnector extends AbstractExtensionConnector {

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void extend(ServerConnector target) {
        // Get the extended widget
        final Widget widget = ((ComponentConnector) target).getWidget();
        widget.getElement().setAttribute("preload","auto");
    }
}