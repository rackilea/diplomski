import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Interceptor implements IMethodInterceptor
{

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context)
    {
        int methCount = methods.size();
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        for (int i = 0; i < methCount; i++)
        {
            IMethodInstance instns = methods.get(i);
            List<String> grps = Arrays.asList(instns.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).groups());
//get these groups from testng.xml via context method parameter                         
            if (grps.contains("A") && grps.contains("B"))
            {
                result.add(instns);
            }                       
        }                       
        return result;
    }
}