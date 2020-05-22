for (final String className : aspectNames) 
{
    final Class<?> aspectClass = Class.forName(className);
    final Object aspect = Aspects.aspectOf(aspectClass);

    // finally (!) do the initialisation on the aspect itself:
    aspect.setLogService(logging);
}