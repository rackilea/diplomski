Map<Integer,String> index2value=new HashMap<Integer,String>();

for (Enumeration e = request.getParameterNames(); e.hasMoreElements() ;)
 {
 String param= e.nextElement().toString();
 if(!param.matches("var\[[0-9]+\]")) continue;
 int index= (here extract the numerical value....)
 index2value.put(index,request.getParameter(param));
 }