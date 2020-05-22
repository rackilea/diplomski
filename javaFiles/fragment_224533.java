ActiveXComponent wmi = new ActiveXComponent("WbemScripting.SWbemLocator");        

  Variant variantParameters[] = new Variant[4];
  variantParameters[0] = new Variant(_IPADDRESS);
  variantParameters[1] = new Variant("root\\cimv2");
  variantParameters[2] = new Variant("username");
  variantParameters[3] = new Variant("password");     
  ActiveXComponent axWMI;
try
{
    Variant conRet = wmi.invoke("ConnectServer", variantParameters);        
    axWMI = new ActiveXComponent(conRet.toDispatch());
}catch(ComFailException e)
{
    axWMI = null;
}
if (axWMI == null)
    return false;