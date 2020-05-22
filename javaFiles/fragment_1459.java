public class MyWebappServlet ... {
  static {
    // to pipe j.u.l
    SLF4JBridgeHandler.install();

    // to pipe System.(out|err)
    SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
  }
  ...