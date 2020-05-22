package com.y.log4j;

import org.apache.log4j.spi.LoggingEvent;

/**
 * This is a general purpose filter. If its "value" property is null, 
 * it requires only that the specified key be set in the MDC. If its 
 * value is not null, it further requires that the value in the MDC 
 * is equal.
 */
public final class ContextFilter extends org.apache.log4j.spi.Filter {

  public int decide(LoggingEvent event) {
    Object ctx = event.getMDC(key);
    if (value == null)
      return (ctx != null) ? NEUTRAL : DENY;
    else
      return value.equals(ctx) ? NEUTRAL : DENY;
  }

  private String key;
  private String value;

  public void setContextKey(String key) { this.key = key; }
  public String getContextKey() { return key; }
  public void setValue(String value) { this.value = value; }
  public String getValue() { return value; }

}