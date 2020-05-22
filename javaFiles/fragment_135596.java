//Following has not been tested
package com.quaternion.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class PostOnlyInterceptor  extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (!request.getMethod().equals("POST")){
            return Action.ERROR;
        }
        return ai.invoke();
    }  
}