public class ParameterListExtension
{
  public static boolean contain(List<Parameter> parameters, String key)
  {
    for(Parameter parameter:parameters)
      if(parameter.key.equals(key)) return true;
    return false;
  }
}