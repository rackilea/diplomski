import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

public class Test {
  public static void main(String[] args) throws InterruptedException, AWTException, IOException {
    RemoteWebDriver driver = new ChromeDriver();
    HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
    URL url = executor.getAddressOfRemoteServer();
    SessionId session_id = driver.getSessionId();
    driver.manage().timeouts().pageLoadTimeout(0, TimeUnit.SECONDS);
    try {
      driver.navigate().to("http://dic.naver.com/");
    }catch (TimeoutException e){
      System.out.println("Time out Exception");
      driver = createDriverFromSession(session_id, url);
      driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
      driver.get("https://stackoverflow.com/");
    }
  }

  public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
    CommandExecutor executor = new HttpCommandExecutor(command_executor) {

      @Override
      public Response execute(Command command) throws IOException {
        Response response = null;
        if (command.getName() == "newSession") {
          response = new Response();
          response.setSessionId(sessionId.toString());
          response.setStatus(0);
          response.setValue(Collections.<String, String>emptyMap());

          try {
            Field commandCodec = null;
            commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
            commandCodec.setAccessible(true);
            commandCodec.set(this, new W3CHttpCommandCodec());

            Field responseCodec = null;
            responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
            responseCodec.setAccessible(true);
            responseCodec.set(this, new W3CHttpResponseCodec());
          } catch (NoSuchFieldException e) {
            e.printStackTrace();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }

        } else {
          response = super.execute(command);
        }
        return response;
      }
    };

    return new RemoteWebDriver(executor, new DesiredCapabilities());
  }
}