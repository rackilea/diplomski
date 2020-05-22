public class Log4NetDiagnosticContextHandler : IDiagnosticContextHandler
{
    private readonly Assembly assembly;

    private readonly Type mdcType;

    public Log4NetDiagnosticContextHandler()
    {
        this.assembly = Assembly.Load("log4net");
        this.mdcType = this.assembly.GetType("log4net.MDC", true);
    }

    public void Set(string name, string value)
    {
        this.mdcType.InvokeMember("Set", BindingFlags.InvokeMethod, null, null, new object[] { name, value });
    }
}