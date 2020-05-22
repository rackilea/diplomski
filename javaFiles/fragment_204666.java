import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConnetionManager {

  private static final Logger _logger = Logger.getLogger(ConnetionManager.class.getName());

  private JSch jschSSHChannel;

  private String strUserName;

  private String strConnectionIP;

  private int intConnectionPort;

  private String strPassword;

  private Session sesConnection;

  private int intTimeOut;

  private void doCommonConstructorActions(String userNameInstance, String tokenpassword, String connetionServerIo,
      String hostFileName) {
    jschSSHChannel = new JSch();
    try {
      jschSSHChannel.setKnownHosts(hostFileName);
    } catch (JSchException exceptionInstance) {
      _logError(exceptionInstance.getMessage());
    }
    strUserName = userNameInstance;
    strPassword = tokenpassword;
    strConnectionIP = connetionServerIo;
  }

  public ConnetionManager(String userName, String password, String connectionIP, String knownHostsFileName) {
    doCommonConstructorActions(userName, password, connectionIP, knownHostsFileName);
    intConnectionPort = 22;
    intTimeOut = 60000;
  }

  public ConnetionManager(String userName, String password, String connectionIP, String knownHostsFileName,
      int connectionPort) {
    doCommonConstructorActions(userName, password, connectionIP, knownHostsFileName);
    intConnectionPort = connectionPort;
    intTimeOut = 60000;
  }

  public ConnetionManager(String userName, String password, String connectionIP, String knownHostsFileName,
      int connectionPort, int timeOutMilliseconds) {
    doCommonConstructorActions(userName, password, connectionIP, knownHostsFileName);
    intConnectionPort = connectionPort;
    intTimeOut = timeOutMilliseconds;
  }

  public String connect() {
    String errorMessage = null;
    try {
      sesConnection = jschSSHChannel.getSession(strUserName, strConnectionIP, intConnectionPort);
      sesConnection.setPassword(strPassword);
      sesConnection.connect(intTimeOut);
    } catch (JSchException exceptionInstance) {
      errorMessage = exceptionInstance.getMessage();
    }
    return errorMessage;
  }

  private String _logError(String errorMessage) {
    if (errorMessage != null) {
      _logger.log(Level.SEVERE, "{0}:{1} - {2}", new Object[] { strConnectionIP, intConnectionPort, errorMessage });
    }
    return errorMessage;
  }

  private String _logWarnings(String warnMessage) {
    if (warnMessage != null) {
      _logger.log(Level.WARNING, "{0}:{1} - {2}", new Object[] { strConnectionIP, intConnectionPort, warnMessage });
    }
    return warnMessage;
  }

  public String sendCommand(String executionCommand) {
    StringBuilder outputBuffer = new StringBuilder();
    try {
      Channel channelInstance = sesConnection.openChannel("exec");
      ((ChannelExec) channelInstance).setCommand(executionCommand);
      InputStream commandOutputStream = channelInstance.getInputStream();
      channelInstance.connect();
      int readByte = commandOutputStream.read();
      while (readByte != 0xffffffff) {
        outputBuffer.append((char) readByte);
        readByte = commandOutputStream.read();
      }
      channelInstance.disconnect();
    } catch (IOException ioExceptionInstance) {
      _logWarnings(ioExceptionInstance.getMessage());
      return null;
    } catch (JSchException schExceptionInstance) {
      _logWarnings(schExceptionInstance.getMessage());
      return null;
    }
    return outputBuffer.toString();
  }

  public void close() {
    sesConnection.disconnect();
  }

}