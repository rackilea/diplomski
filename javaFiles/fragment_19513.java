package com.stackoverflow.questions52609313.client;

import com.google.gwt.user.client.ui.PopupPanel;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, name = "GwtPopupPanel")
public class PopupPanelJsWrapper {
   private PopupPanel popupPanel = new PopupPanel();


   @JsMethod
   public void hide() {
       popupPanel.hide();
   }

   @JsMethod
   public void show() {
       popupPanel.show();
   }
}