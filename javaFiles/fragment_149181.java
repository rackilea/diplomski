package de.scrum_master.app;

import java.io.IOException;

public class ConfigStruct implements Runnable {
  private String name;

  public ConfigStruct(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    StringBuffer runCmd = generateGalishFullCommand(GalishFlags.RUN);
    try {
      ExternalCommandExecutor.execute(runCmd.toString(), "Failed to run " + name, true, true);
    } catch (IOException e) {
      throw new ConfigurationException(e.getMessage(), e);
    }
  }

  private StringBuffer generateGalishFullCommand(GalishFlags run) {
    return new StringBuffer("Galish full command for ConfigStruct '" + name + "'");
  }
}