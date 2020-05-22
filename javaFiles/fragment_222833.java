final ObjectName dr = (ObjectName) this.domain.getAttribute(domainObjectName, "DomainRuntime");
final ObjectName dm = (ObjectName) this.domain.getAttribute(dr, "DeploymentManager");
final ObjectName[] adrs = (ObjectName[]) this.domain.getAttribute(dm, "AppDeploymentRuntimes");
for (final ObjectName on : adrs)
{
    if (this.domain.getAttribute(on, "ApplicationName").equals(appName))
    {
        this.domain.invoke(on, "stop", null, null);
        break;
    }
}