#set($elem = '"System.NotImplementedException: Test Exception')                                                                                                                                                 
#set($trace = $elem.replace('"',""))
#set($dot = $trace.lastIndexOf('.'))
#set($className = $trace.substring(0, $dot))
#set($method = $trace.substring($dot + 1))
{
  "className": "$className",
  "method": "$method"
}