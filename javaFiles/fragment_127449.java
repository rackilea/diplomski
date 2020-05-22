int locationx = Integer.parsInt(plugin.getConfig().getString("locationx"));
int eventlocationx = event.getClickedBlock().getX();

int locationy = Integer.parsInt(plugin.getConfig().getString("locationy"));
int eventlocationy = event.getClickedBlock().getY();

int locationz = Integer.parsInt(plugin.getConfig().getString("locationz"));
int eventlocationz = event.getClickedBlock().getZ();

if (locationx == eventlocationx && locationy == eventlocationy && locationz == 
eventlocationz)
{
System.out.println("SUCCESS: Passed coordinate check on the right click.");
 return true;
}
else
{
System.out.println(locationx);
System.out.println(eventlocationx);

System.out.println(locationy);
System.out.println(eventlocationy);

System.out.println(locationz);
System.out.println(eventlocationz);

System.out.println("ERROR: Failed on the right click coordinate check.");
return false;
}