org.omg.CORBA.Request r = item._request("actionA");
r.add_in_arg().insert_float(a);
Any val = r.add_out_arg();
val.type(orb.get_primitive_tc(TCKind.tk_long));
r.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
r.invoke();

if( r.env().exception() == null )
{
    System.out.println("returned: " + r.arguments().item(1).value().extract_long());  
}