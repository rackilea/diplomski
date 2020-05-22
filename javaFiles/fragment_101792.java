public class MyScreen extends MainScreen{
Player _p;
VideoControl _videoControl;  
FileConnection fileconn;
String PATH;
String GetfileName;
LabelField GetPhotofileName = new LabelField("",LabelField.FOCUSABLE){
    protected boolean navigationClick(int status, int time){
        Dialog.alert("Clicked");
    return true;
    }
 };

 public static boolean SdcardAvailabulity() {
     String root = null;
     Enumeration e = FileSystemRegistry.listRoots();
     while (e.hasMoreElements()) {
         root = (String) e.nextElement();
         if( root.equalsIgnoreCase("sdcard/") ) {
             return true;
         }else if( root.equalsIgnoreCase("store/") ) {
             return false;
         }
     }
     class MySDListener implements FileSystemListener {
         public void rootChanged(int state, String rootName) {
             if( state == ROOT_ADDED ) {
                 if( rootName.equalsIgnoreCase("sdcard/") ) {
                 }
             } else if( state == ROOT_REMOVED ) {
             }
         }
     }
     return true;
 }
 protected boolean invokeAction(int action){
     boolean handled = super.invokeAction(action); 
     if(SdcardAvailabulity()){
           PATH = System.getProperty("fileconn.dir.memorycard.photos")+"Image_"+System.currentTimeMillis()+".jpg";//here "str" having the current Date and Time;
     } else {
         PATH = System.getProperty("fileconn.dir.photos")+"Image_"+System.currentTimeMillis()+".jpg"; 
     }
     if(!handled){
         if(action == ACTION_INVOKE){   
             try{                      
                 byte[] rawImage = _videoControl.getSnapshot(null);
                 fileconn=(FileConnection)Connector.open(PATH);
                 if(fileconn.exists()){
                    fileconn.delete();
                 }
                 fileconn.create();
                 OutputStream os=fileconn.openOutputStream();
                 os.write(rawImage);
                 GetfileName =fileconn.getName();
                 fileconn.close();
                 os.close();
                 Status.show("Image is Captured",200);
                 GetPhotofileName.setText(GetfileName);
                 if(_p!=null)
                    _p.close();          
             }catch(Exception e){
                if(_p!=null){
                    _p.close();
                 }
                 if(fileconn!=null){
                    try{
                         fileconn.close();
                     }catch (IOException e1){ 
                     }
                 }                    
             }
         }
      }           
      return handled;                
  }
 public MyScreen(){
     setTitle("Camera App");
     try{
        _p = javax.microedition.media.Manager.createPlayer("capture://video?encoding=jpeg&width=1024&height=768");
        _p.realize();
        _videoControl = (VideoControl) _p.getControl("VideoControl");
        if (_videoControl != null){
            Field videoField = (Field) _videoControl.initDisplayMode (VideoControl.USE_GUI_PRIMITIVE, "net.rim.device.api.ui.Field");
            _videoControl.setDisplayFullScreen(true);
             _videoControl.setVisible(true);
            _p.start();
            if(videoField != null){
                add(videoField);
            }
        } 
     }catch(Exception e){
         if(_p!=null) {
             _p.close();
         }
         Dialog.alert(e.toString());
     }   
     add(GetPhotofileName);
 }
}