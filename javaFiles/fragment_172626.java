package pkg;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

@Intercepts({
  @Signature(
      type = Executor.class, 
      method = "update", 
      args = { MappedStatement.class, Object.class }),
  @Signature(
      type = Executor.class, 
      method = "query", 
      args = { MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class })
})
public class LogStatementIdInterceptor implements Interceptor {
  private static final Logger logger = Logger.getLogger(LogStatementInterceptor.class);
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
    logger.debug(ms.getId());
    return invocation.proceed();
  }
}