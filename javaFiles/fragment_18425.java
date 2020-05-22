package cl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

public class ClientPoll extends Thread {
  private void readProperties() {
    try {
      Path path = Paths.get("radar.properties");
      InputStream input =new FileInputStream(path.toString());
      Properties prop = new Properties();
      prop.load(input);
      String property = prop.getProperty("updateRate");
      System.out.println("property="+property);
      int updateRate = Integer.parseInt(property);
//      System.out.println(updateRate);
      input.close();
    } catch (IOException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public void run() {
    try {
      WatchService watcher = FileSystems.getDefault().newWatchService();
      Path directory = Paths.get(".");
      WatchKey watchKey = directory.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
      while (true) {
        WatchKey wk = watcher.take();
        for (WatchEvent<?> event : wk.pollEvents()) {
          Path changed = (Path) event.context();
          if (changed.toString().equals("radar.properties")) {
            try {
              readProperties();
            } catch (Exception e) {
              e.printStackTrace(System.out);
            }
          }
        }
        if (!watchKey.reset()) {
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace(System.out);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new ClientPoll().start();
    new Writer().start();
  }
}

class Writer extends Thread {
  @Override
  public void run() {
    try {
      for (int i=0;i<10;i++) {
        File f = new File("radar.properties");
        FileWriter fw = new FileWriter(f);
        fw.write("updateRate="+i*1000);
        fw.close();
        sleep(1000L);
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
    System.out.println("exit");
    System.exit(0);
  }
}