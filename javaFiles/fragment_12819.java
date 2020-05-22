try{
    Process su = Runtime.getRuntime().exec("su");
    DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

    outputStream.writeBytes("screenrecord --time-limit 10 /sdcard/MyVideo.mp4\n");
    outputStream.flush();

    outputStream.writeBytes("exit\n");
    outputStream.flush();
    su.waitFor();
}catch(IOException e){
    throw new Exception(e);
}catch(InterruptedException e){
    throw new Exception(e);
}