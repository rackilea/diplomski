package de.scrum_master.app;

public class ConfigurationException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}