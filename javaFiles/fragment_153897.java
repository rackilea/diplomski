package x;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class TemplatesDebugInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 4030044344066761593L;
    Log log = LogFactory.getLog(TemplatesDebugInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            if (ServletActionContext.getActionMapping() != null) {
                String className = invocation.getAction().getClass().getCanonicalName();
                String methodName = ServletActionContext.getActionMapping().getMethod();
                log.info("===========================");
                log.info(className+"."+methodName);
            }
            invocation.addPreResultListener(new PreResultListener() {
                public void beforeResult(ActionInvocation invocation,String resultCode) {
                    Map<String, ResultConfig> resultsMap = invocation.getProxy().getConfig().getResults();
                    ResultConfig finalResultConfig = resultsMap.get(resultCode);
                    log.info(finalResultConfig.getParams());
                }
            });
        } catch (Exception e) {
            log.error("[ERROR] Could not list templates: ", e);
        }
        return invocation.invoke();
    }
}