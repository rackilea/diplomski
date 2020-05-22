try
{
    Class.forName(classname, true, MiscTools.addToClasspath(cptoadd);
}
catch (ClassNotFoundException IllegalArgumentException | SecurityException e)
{
    classlogger.log(Level.WARNING, "Error loading ".concat(props.getProperty("Class")), e);
}