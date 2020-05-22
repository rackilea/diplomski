String commandStr =  "cmd /c C:\\Programs Files\\Common Files\\Microsoft Shared\\ink\\TabTip.exe";   // Like you did

InputStream is = rt.exec( commandStr ).getErrorStream();
int b;
while((b=(is.read()))!=-1)
  System.out.print((char)b);
}