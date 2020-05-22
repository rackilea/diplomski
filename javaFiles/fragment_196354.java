package com.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

public class MyAnnotationMethodHandlerAdapter extends AnnotationMethodHandlerAdapter {

    protected ModelAndView invokeHandlerMethod(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof MyMarkerInterface) {
            MyMarkerInterface handler2 = (MyMarkerInterface) handler;
            handler2.updateModelAfterPost(request);
        }
        return super.invokeHandlerMethod(request, response, handler);
    }

}


package com.sample;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

public class MySimpleControllerHandlerAdapter extends SimpleControllerHandlerAdapter implements Ordered {

    private int order = 0;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


}