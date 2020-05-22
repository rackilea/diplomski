import pervasive.database.*;

public class VersionTest implements Consts
{
public VersionTest()
{
try
{
Session session = Driver.establishSession(); 
Database db = session.connectToDatabase("PMKE:"); 
XCursor xcursor = db.createXCursor(57000); 
//Using local TABL.DAT (length 255 assures no leftovers!)
xcursor.setKZString(0,255,"plsetup\\tabl.dat");
//Open the file to load local MKDE
int status = xcursor.BTRV(BTR_OPEN);
System.out.println("Local Open status: " + status);
//Using remote TABL.DAT (length 255 assures no leftovers!)

xcursor.setKZString(0,255,"h:\\basic2c\\develop\\tabl.dat");
//set the buffer size
xcursor.setDataSize(15);
//get version 
status = xcursor.BTRV(BTR_VERSION);
System.out.println("Version status: " + status);
// should be 15, always prints 5
System.out.println("Version length: " + xcursor.getRecLength());
System.out.println("Version: " + xcursor.getDString(0,15));

// try with an open file on a server
XCursor xcursor2 = db.createXCursor(57000); 
//Using remote TABL.DAT (length 255 assures no leftovers!)

xcursor2.setKZString(0,255,"h:\\basic2c\\develop\\tabl.dat");
//Open the file
status = xcursor2.BTRV(BTR_OPEN);
System.out.println("Remote Open status: " + status);
//set the buffer size
xcursor2.setDataSize(15);
//get version 
status = xcursor2.BTRV(BTR_VERSION);
System.out.println("Version status: " + status);
// should be 15, always prints 5
System.out.println("Version length: " + xcursor2.getRecLength());
System.out.println("Version: " + xcursor2.getDString(0,15));

// clean up resources 
Driver.killAllSessions();
}catch(Exception exp)
{
exp.printStackTrace();
}
}
public static void main(String[] args) 
{
new VersionTest();
}
}