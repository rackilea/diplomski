char** vmargs = NULL;
int vmargc = 5;
{
    // Configure the VM Args for the JVM
    vmargs = new char*[vmargc];

    vmargs[0] = new char[1024];
    vmargs[1] = new char[1024];
    vmargs[2] = new char[1024];
    vmargs[3] = new char[1024];
    vmargs[4] = new char[1024];

    _snprintf_s(vmargs[0], 1024,_TRUNCATE, "-Djava.library.path=%s\\bin\\lib", root.c_str());       
   _snprintf_s(vmargs[1], 1024,_TRUNCATE, "-Djava.class.path=%s\\bin\\%s", root.c_str(), JarName);
   _snprintf_s(vmargs[2], 1024,_TRUNCATE, "-Xrs");
   _snprintf_s(vmargs[3], 1024,_TRUNCATE, "-Xdebug");
   _snprintf_s(vmargs[4], 1024,_TRUNCATE, "-Xrunjdwp:transport=dt_socket,address=8989,server=y,suspend=y");

    Log( "vmarg %d:%s.\n",0,vmargs[0]);
    Log( "vmarg %d:%s.\n",1,vmargs[1]);
    Log( "vmarg %d:%s.\n",2,vmargs[2]);
    Log( "vmarg %d:%s.\n",3,vmargs[3]);
    Log( "vmarg %d:%s.\n",4,vmargs[4]);
}