try
{
   WindowsFileAttributes windowsfileattributes = WindowsFileAttributes.get(windowspath2, false);
   if(windowsfileattributes.isDirectory() || windowsfileattributes.isDirectoryLink())
      i |= 1;
}