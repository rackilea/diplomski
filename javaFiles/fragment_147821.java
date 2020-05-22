#set($elem = '"System.NotImplementedException: Test Exception')                                                                                                                                                 
#set($trace = $elem.replace('"',""))
#set($colon = $trace.indexOf(':'))
#set($dot = $trace.lastIndexOf('.', $colon))
#set($className = $trace.substring(0, $dot))
#set($method = $trace.substring($dot + 1))
{
  "className": "$className",
  "method": "$method"
}