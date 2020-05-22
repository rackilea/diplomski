package com.edwinbuck;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.tools.ant.BuildLogger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.util.StringUtils;

public class JavacFileLogger implements BuildLogger {

  protected PrintStream out;

  protected PrintStream err;

  protected static final String eol = StringUtils.LINE_SEP;

  private Set<String> errorFiles = new HashSet<String>();

  private boolean ignoringMessages = true;

  public void buildStarted(BuildEvent event) {
  }

  public void buildFinished(BuildEvent event) {
  }

  public void targetStarted(BuildEvent event) {
  }

  public void targetFinished(BuildEvent event) {
  }

  public void taskStarted(BuildEvent event) {
    if (event.getTask().getTaskName().equals("javac")) {
      ignoringMessages = false;
    }
  }

  public void taskFinished(BuildEvent event) {
    if (event.getTask().getTaskName().equals("javac")) {
      ignoringMessages = true;
      // flush the set of files with errors
      for (String filename : errorFiles) {
        out.print(filename);
        out.print(eol);
      }
    }
  }

  public void messageLogged(BuildEvent event) {
    // we don't care about non-javac messages
    if (!ignoringMessages) {
      // error messages have a distinct ".java:" in the line containing the file name.
      if (event.getMessage().contains(".java:")) {
        // just add the (string) name to the set to condense multiple reported errors in the same file
        errorFiles.add(event.getMessage().substring(0, event.getMessage().indexOf(":")));
      }
    }
  }

  public void setErrorPrintStream(PrintStream err) {
    this.err = err;
  }

  public void setEmacsMode(boolean emacsMode) {
  }

  public void setOutputPrintStream(PrintStream output) {
    this.out = output;
  }

  public void setMessageOutputLevel(int level) {
    // this logger ignores message levels
  }

}