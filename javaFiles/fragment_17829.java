public static void saveData(SaveState instance){
ObjectOutput out;
try {
     File outFile = new File(Environment.getExternalStorageDirectory(), "appSaveState.ser");
     out = new ObjectOutputStream(new FileOutputStream(outFile));
     out.writeObject(instance);
     out.close();
 } catch (Exception e) {e.printStackTrace();}
}

public static SaveState loadData(){
 ObjectInput in;
 SaveState ss=null;
 try {
     in = new ObjectInputStream(new FileInputStream("appSaveState.ser"));       
     ss=(SaveState) in.readObject();
     in.close();
 } catch (Exception e) {e.printStackTrace();}
 return ss;
}