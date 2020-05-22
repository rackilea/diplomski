long hWnd = 0
try{ 
  Class clazz = Class.forName("sun.awt.windows.WComponentPeer);
  synchronized(overlay.getTreeLock()){
    ComponentPeer peer = overlay.getPeer();
    if (clazz.isInstance(peer)){
      hWnd = ((sun.awt.windows.WComponentPeer) overlay.getPeer()).getHWnd();
    }
  }
}catch(ClassNotFound _noWindows){
//process..
}