String str1="192.168.0.201";
String str2="255.255.255.0";
String[] command1 = { "netsh", "interface", "ip", "set", "address",
"name=", "Local Area Connection" ,"source=static", "addr=",str1,
"mask=", str2};
Process pp = java.lang.Runtime.getRuntime().exec(command1);