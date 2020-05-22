package com.stackoverflow.questions.31556478;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLauncher
{
  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLauncher.class);

  private static SomeServer mServer;

  public static void start(final String[] args)
  {
    LOGGER.debug("Start called: {}", Arrays.toString(args));

    try
    {
      mServer = new SomeServer(args);
      mServer.start();
    }
    catch (final Exception e)
    {
      LOGGER.error("Terminating due to Exception: ", e);
    }
  }

  public static void stop(final String[] args) throws Exception
  {
    LOGGER.debug("Stop called: {}", Arrays.toString(args));

    synchronized (ServiceLauncher.class)
    {
      if (mServer != null)
      {
        mServer.stop();
      }
    }
  }
}