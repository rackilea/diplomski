Camera.Parameters p= mCamera.getParameters();

if(p.getFlashMode().equals(android.hardware.Camera.Parameters.FLASH_MODE_ON))
{
 //DO STUFF...
}
else if(p.getFlashMode().equals(android.hardware.Camera.Parameters.FLASH_MODE_OFF))
{
//DO STUFF......
}
else if(p.getFlashMode().equals(android.hardware.Camera.Parameters.FLASH_MODE_TORCH))
{
//DO STUFF......
}
else if(p.getFlashMode().equals(android.hardware.Camera.Parameters.FLASH_MODE_AUTO))
{
//DO STUFF......
}
else
{
//DO STUFF.....
}