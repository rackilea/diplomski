User32 user32 = User32.INSTANCE;
  char path[] = new char[512];

  long sleepTime = 2000;
  try {
     Thread.sleep(sleepTime);
  } catch (InterruptedException e) {}

  HWND hWnd = user32.GetForegroundWindow();
  user32.GetWindowModuleFileName(hWnd, path, 512);
  System.out.println("Foreground Window Module FileName: " + 
          Native.toString(path));

  user32.GetWindowText(hWnd, path, 512);
  System.out.println("Window text is: " + Native.toString(path));