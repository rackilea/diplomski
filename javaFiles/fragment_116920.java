package de.scrum_master.app;

import java.io.IOException;

public class Application {
  public String doSomething(Integer number) {
    return number.toString();
  }

  public void doSomethingElse(boolean doThrow) throws MySpecificException {
    if (doThrow)
      throw new MySpecificException();
  }

  public void doWhatever(boolean doThrow) throws MySpecificException, IOException {
    if (doThrow)
      throw new MySpecificException();
    else
      throw new IOException();
  }

  public static void main(String[] args) throws MySpecificException, IOException {
    Application application = new Application();

    // Just so as not to mess up the console output in the IDE for this demo
    System.setErr(System.out);

    // No exceptions here
    application.doSomething(11);
    application.doSomethingElse(false);

    // Let's catch some exceptions
    try {
      application.doSomethingElse(true);
    } catch (MySpecificException e) {
      System.out.println("Caught " + e);
    }
    try {
      application.doWhatever(true);
    } catch (MySpecificException e) {
      System.out.println("Caught " + e);
    }
    try {
      application.doWhatever(false);
    } catch (IOException e) {
      System.out.println("Caught " + e);
    }

    // Do not catch this one
    application.doSomethingElse(true);
  }
}