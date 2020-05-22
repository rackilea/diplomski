@Log4j
@NoArgsConstructor
public class MyDetailQuartzJobBean extends QuartzJobBean {

private String targetObject;
private String targetMethod;
private ApplicationContext ctx;

@Override
protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    try {
        Object bean = ctx.getBean(targetObject);
        Method m = bean.getClass().getMethod(targetMethod);
        m.invoke(bean, null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void setApplicationContext(ApplicationContext applicationContext) {
    this.ctx = applicationContext;
}

public void setTargetObject(String targetObject) {
    this.targetObject = targetObject;
}

public void setTargetMethod(String targetMethod) {
    this.targetMethod = targetMethod;
}
}