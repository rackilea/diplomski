Throwable rootCause = getRootCause(throwable);
if (FacesException.class.isAssignableFrom(rootCause.getClass()))
{
   // perform sepecfic logic 
   // maybe you dont want to handle this exception
}