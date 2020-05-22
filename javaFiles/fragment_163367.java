private static int port=9000;
public static int detectPort(int prt)
{
try{
//connect to port
}
catch(Exception e)
{
return detectPort(prt+1);
}
return prt;
}

// Write detectPort(port); inside main