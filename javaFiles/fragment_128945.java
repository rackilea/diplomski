try
{
    if(Policy!=null)
    {
        ...
    }
    else
    {
        throw new PolicyMissingExc(“Policy missing”);
    }
}
catch(PolicyMissingExc e)
{
  e.printstacktrace();
}
catch(PolicyExpired c)
{
  //catch c here
}
catch(SettlementException b)
{
  //catch b here
}