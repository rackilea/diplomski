public class DataValidationInInterceptor extends AbstractPhaseInterceptor<Message>
{
public DataValidationInInterceptor()
{
    super(Phase.READ);
}

@Override
public void handleMessage(Message message)
{
    OperationResourceInfo ori = message.getExchange().get(OperationResourceInfo.class);
    Method method = ori.getMethodToInvoke();
    Class<?>[] types = method.getParameterTypes();
    Type[] genericParameterTypes = method.getGenericParameterTypes();

    for (int i = 0; i < types.length; i++)
    {
        Class<?> type = types[i];
        List obj = (List) message.getContent(List.class);
        System.out.println(obj);
        System.out.println(type);
    }
}
}