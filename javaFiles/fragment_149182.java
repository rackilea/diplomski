package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
  public void runConfigurations(List<ConfigStruct> configurations) {
    for (ConfigStruct configuration : configurations) {
      try {
        configuration.run();
      } catch (ConfigurationException e) {
        continue;
      }
    }
  }

  public void runConfigurationsThreaded(List<ConfigStruct> configurations) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (ConfigStruct configuration : configurations)
      executorService.execute(configuration);
    executorService.shutdown();
    try {
      executorService.awaitTermination(30, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    List<ConfigStruct> configurations = new ArrayList<>();
    for (int i = 1; i <= 13; i++)
      configurations.add(new ConfigStruct("Configuration " + i));

    long startTime = System.currentTimeMillis();
    new Application().runConfigurations(configurations);
    System.out.println("Total time (1 thread)  = " + (System.currentTimeMillis() - startTime) + " ms");
    System.out.println();

    startTime = System.currentTimeMillis();
    new Application().runConfigurationsThreaded(configurations);
    System.out.println("Total time (5 threads) = " + (System.currentTimeMillis() - startTime) + " ms");
  }
}