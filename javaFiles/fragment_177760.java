public class MyFileDownloader extends TimerTask {
String serverName;
MyFileDownloader(String serverName){this.serverName= serverName}
    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        downloadFiles(serverName);//your code which downloads file from server
        System.out.println("Timer task finished at:"+new Date());
    }
}