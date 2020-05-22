package com.example;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@FacesComponent(value="testCC")
public class TestCC extends UINamingContainer {

    public void ajaxEventListener(AjaxBehaviorEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        MethodExpression ajaxEventListener = (MethodExpression) getAttributes().get("ajaxEventListener");
        ajaxEventListener.invoke(context.getELContext(), new Object[] { event });
    }

}