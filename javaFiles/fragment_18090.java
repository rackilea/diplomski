Process process = Runtime.getRuntime().exec("su");
DataOutputStream out = new DataOutputStream(process.getOutputStream());
out.writeBytes("mount -o remount,rw /system\n");
out.writeBytes("mv /system/file.old system/file.new\n");
out.writeBytes("exit\n");  
out.flush();
process.waitFor();