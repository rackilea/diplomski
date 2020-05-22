Caused By: org.glassfish.hk2.api.UnsatisfiedDependencyException: There was no object available for injection at SystemInjecteeImpl(requiredType=Database,parent=AuthzEndPoint,qualifiers={},position=-1,optional=false,self=false,unqualified=null,1091065126)
at org.jvnet.hk2.internal.ThreeThirtyResolver.resolve(ThreeThirtyResolver.java:75)
at org.jvnet.hk2.internal.Utilities.justInject(Utilities.java:941)
at org.jvnet.hk2.internal.ServiceLocatorImpl.inject(ServiceLocatorImpl.java:980)
at org.glassfish.jersey.ext.cdi1x.internal.AbstractCdiBeanHk2Factory$2.getInstance(AbstractCdiBeanHk2Factory.java:142)
at org.glassfish.jersey.ext.cdi1x.internal.AbstractCdiBeanHk2Factory._provide(AbstractCdiBeanHk2Factory.java:91)
Truncated. see log file for complete stacktrace