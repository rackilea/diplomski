import org.springframework.stereotype.Component;   
import javax.annotation.*;
import javax.annotation.*;
import java.io.*;
import java.net.*;
import java.util.*;

@Component
@Profile("integration")
public class SandboxServerProcess {
    private static final String WAR = "../backend/target/backend.war";
    private final static int PORT = 8081;
    private boolean startedByMe;

    @PostConstruct
    public void start() throws Exception {
        if (isStarted()) {
            return;
        }
        testWarExists();
        packagedWar("start");
        if (waitForStartup()) {
            startedByMe = true;
            return;
        }
        throw new RuntimeException("Sandbox Server not started");
    }

    private void testWarExists() {
        File file = new File(WAR);
        if (!file.exists()) {
            throw new RuntimeException("WAR does not exist:" + file.getAbsolutePath());
        }
    }

    @PreDestroy
    public void stop() throws IOException {
        if (startedByMe) {
            packagedWar("stop");
        }
    }

    private void packagedWar(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.environment().put("MODE", "service");
        builder.environment().put("SPRING_PROFILES_ACTIVE", "integration");
        builder.environment().put("APP_NAME", "backend");
        builder.environment().put("PID_FOLDER", "./");
        builder.environment().put("LOG_FOLDER", "./");
        List<String> commands = new ArrayList<>();
        commands.add(WAR);
        commands.add(command);
        builder.command(commands);
        builder.inheritIO();
        builder.redirectErrorStream(true);
        builder.start();
    }

    private boolean isStarted() {
        try {
            Socket socket = new Socket();
            InetSocketAddress sa = new InetSocketAddress("localhost", PORT);
            socket.connect(sa, 500);
            logger.warn("SandboxServer is started");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean waitForStartup() throws InterruptedException {
        for (int i = 1; i < 30; i++) {
            if (isStarted()) {
                return true;
            }
            logger.warn("SandboxServer not yet ready, tries: " + i);
            Thread.sleep(1000);
        }
        return false;
    }
}