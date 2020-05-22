permission java.lang.RuntimePermission "loadLibrary.rxtxSerial";

   permission java.io.FilePermission "${java.home}${/}lib${/}ext${/}amd64${/}librxtxSerial.so", "read";

   permission java.io.FilePermission "${java.home}${/}lib${/}ext${/}librxtxSerial.so", "read";

   permission java.io.FilePermission "${/}dev", "read";

   permission java.util.PropertyPermission "gnu.io.log.mode", "read";

   permission java.util.PropertyPermission "gnu.io.SerialPorts", "write,read";

   permission java.util.PropertyPermission "gnu.io.rxtx.SerialPorts", "read,write";

   permission java.util.PropertyPermission "gnu.io.ParallelPorts", "read";

   permission java.util.PropertyPermission "gnu.io.rxtx.ParallelPorts", "read";

   permission java.lang.RuntimePermission "modifyThreadGroup";

   permission java.lang.RuntimePermission "modifyThread";