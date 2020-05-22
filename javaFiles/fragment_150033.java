1)
In setEnv file located in your weblogic server path(i.e /apps/appName/bin) added:
JAVA_OPTIONS="${JAVA_OPTIONS} -Dhttps.proxyHost=x.y.z"
JAVA_OPTIONS="${JAVA_OPTIONS} -Dhttps.proxyPort=port"
JAVA_OPTIONS="${JAVA_OPTIONS} -Dhttps.nonProxyHosts=*.y.z"

2) In weblogic console: servers-> keystores Change from “Demo identity and Demo trust” to “Custom Identity
and Java Standard Trust”

3) in weblogic console: servers-> SSL-> advanced-> Tick “Use JSSE SSL” and also set “Hostname Verification” to
none