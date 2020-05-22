// // additional permissions for running TestNG // // 

// TestNG reads a lot of properties...
permission java.util.PropertyPermission "*", "read";

// TestNG connects to a local port for debugging, and does some reflection magic
permission java.net.SocketPermission "127.0.0.1:*", "connect,resolve";
permission java.lang.RuntimePermission "accessDeclaredMembers";
permission java.lang.reflect.ReflectPermission "suppressAccessChecks";

// needs at least read access to (default) test suite folder location
permission java.io.FilePermission "C:/Users/<me>/AppData/Local/Temp/-", "read, write";

// if the test case (or, data provider) accesses any other files, add their location. or do it the lazy way:
permission java.io.FilePermission "C:/-", "read, write";