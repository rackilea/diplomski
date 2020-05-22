/**
 * Executes a given OS dependent command in a given directory with a given environment. 
 * The parameters are given at construction time and the initialized object is immutable.
 * After the object initialization and execution of the blocking exec() method the state
 * can't be changed. The result of the execution can be accessed through the get methods
 * for the exitValue, stdOut, and stdErr properties. Before the exec() method is completed
 * the excuted property is false and the result of other getters is undefined (null).
 */
public class CommandExecutor {
  /**
  * Specifies the number of times the termination of the process is
  * waited for if the OS gives interruptions
  */
  public static final int NUMBER_OF_RUNS = 2;

  /**
  * Used for testing and as example of usage.
  */
  public static void main(String[] args) {
    System.out.println("CommandExecutor.main Testing Begin");
    String command_01 = "cmd.exe /C dir";
    File dir_01 = new File("C:\\");
    System.out.println("CommandExecutor.main Testing. Input: ");
    System.out.println("CommandExecutor.main Testing. command: " + command_01);
    System.out.println("CommandExecutor.main Testing. dir: " + dir_01);
    CommandExecutor ce_01 = new CommandExecutor(command_01, null, dir_01);
    ce_01.exec();
    System.out.println("CommandExecutor.main Testing. Output:");
    System.out.println("  exitValue: " + ce_01.getExitValue());
    System.out.println("  stdout: " + ce_01.getStdout());
    System.out.println("  stderr: " + ce_01.getStderr());

    String command_02 = "cmd.exe /C dirs";
    File dir_02 = new File("C:\\");
    System.out.println("CommandExecutor.main Testing. Input: ");
    System.out.println("CommandExecutor.main Testing. command: " + command_02);
    System.out.println("CommandExecutor.main Testing. dir: " + dir_02);
    CommandExecutor ce_02 = new CommandExecutor(command_02, null, dir_02);
    ce_02.exec();
    System.out.println("CommandExecutor.main Testing. Output:");
    System.out.println("  exitValue: " + ce_02.getExitValue());
    System.out.println("  stdout: " + ce_02.getStdout());
    System.out.println("  stderr: " + ce_02.getStderr());

    System.out.println("CommandExecutor.main Testing End");
  }

  /*
   * The command to execute
   */
  protected String command;

  /*
   * The environment to execute the command with
   */
  protected String[] env;

  /*
   * The directory to execute the command in
   */
  protected File dir;

  /*
   * Flag set when the command has been executed
   */
  protected boolean executed = false;

  /*
   * Exit value from the OS
   */
  protected int exitValue;

  /*
   * Handle to the spawned OS process
   */
  protected Process process;

  /*
   * Std error
   */
  protected List<String> stderr;

  /*
   * Worker Thread to empty the stderr buffer
   */
  protected Thread stderrReader;

  /*
   * Std output
   */
  protected List<String> stdout;

  /*
   * Worker Thread to empty the stdout buffer
   */
  protected Thread stdoutReader;

  /**
   * Creates a new instance of the CommandExecutor initialized to execute the
   * specified command in a separate process with the specified environment
   * and working directory.
   *
   * @param env
   */
  public CommandExecutor(String command, String[] env, File dir) {
    this.command = command;
    this.env = env;
    this.dir = dir;
  }

  /**
   * Creates a reader thread for the stderr
   */
  protected void connectStderrReader() {
    stderr = new ArrayList<String>();
    final InputStream stream = process.getErrorStream();
    final BufferedReader reader = 
      new BufferedReader(new InputStreamReader(stream));
    stderrReader = new Thread(new Runnable() {
      public void run() {
        String nextLine = null;
        try {
          while ((nextLine = reader.readLine()) != null) {
            stderr.add(nextLine);
          }
        } catch (IOException e) {
          System.out.println(
            "CommandExecutor.connectStderrReader() error in reader thread");
          e.printStackTrace(System.out);
        }
      }
    });
    stderrReader.start();
  }

  /**
   * Creates a reader thread for the stdout
   */
  protected void connectStdoutReader() {
    stdout = new ArrayList<String>();
    final InputStream stream = process.getInputStream();
    final BufferedReader reader =
      new BufferedReader(new InputStreamReader(stream));
    stdoutReader = new Thread(new Runnable() {
      public void run() {
        String nextLine = null;
        try {
          while ((nextLine = reader.readLine()) != null) {
            stdout.add(nextLine);
          }
        } catch (IOException e) {
          System.out.println(
          "CommandExecutor.connectStdoutReader() error in reader thread");
          e.printStackTrace(System.out);
        }
      }
    });
    stdoutReader.start();
  }

  /**
   * Creates the process for the command
   */
  protected void createProcess() {
    try {
      process = Runtime.getRuntime().exec(command, env, dir);
    } catch (IOException e) {
      System.out.println("CommandExecutor.exec() error in process creation. Exception: " + e);
      e.printStackTrace(System.out);
    }
  }

  /**
   * Executes command in a separate process in the specified directory. Method will block until
   * the process has terminated. Command will only be executed once.
   */
  public synchronized void exec() {
    // Future enhancement: check for interrupts to make the blocking nature interruptible.
    if (!executed) {
      createProcess();
      connectStdoutReader();
      connectStderrReader();
      waitForProcess();
      joinThreads();
      exitValue = process.exitValue();
      executed = true;
    }
  }

  /**
   * @return the command
   */
  public String getCommand() {
    return command;
  }

  /**
   * @return the dir
   */
  public File getDir() {
    return dir;
  } 

  /**
   * @return the env
   */
  public String[] getEnv() {
    return env;
  }

  /**
   * @return the exitValue
   */
  public int getExitValue() {
    return exitValue;
  }

  /**
   * @return the stderr
   */
  public List<String> getStderr() {
    return stderr;
  }

  /**
   * @return the stdout
   */
  public List<String> getStdout() {
    return stdout;
  }

  /**
   * @return the executed
   */
  public boolean isExecuted() {
    return executed;
  }

  /**
   * Joins on the 2 Reader Thread to empty the buffers
   */
  protected void joinThreads() {
    try {
      stderrReader.join();
      stdoutReader.join();
    } catch (InterruptedException e) {
      System.out.println("CommandExecutor.joinThreads() error. Exception: ");
      e.printStackTrace(System.out);
    }
  }

  /**
   * Creates a String representing the state of the object
   */
  @Override
  public synchronized String toString() {
    StringBuilder result = new StringBuilder();
    result.append("CommandExecutor:");
    result.append("  command: " + command);
    result.append("  env: " + Arrays.deepToString(env));
    result.append("  dir: " + dir);
    result.append("  executed: " + executed);
    result.append("  exitValue: " + exitValue);
    result.append("  stdout: " + stdout);
    result.append("  stderr: " + stderr);
    return result.toString();
  }

  /**
   * Waits for the process to terminate
   */
  protected void waitForProcess() {
    int numberOfRuns = 0;
    boolean terminated = false;
    while ((!terminated) && (numberOfRuns < NUMBER_OF_RUNS)) {
      try {
        process.waitFor();
        terminated = true;
      } catch (InterruptedException e) {
        System.out.println("CommandExecutor.waitForProcess() error");
        e.printStackTrace(System.out);
        numberOfRuns++;
      }
    }
  }
}