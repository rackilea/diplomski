try {
         java.rmi.registry.LocateRegistry.createRegistry(1099);
         System.out.println("RMI registry ready.");
      } catch (Exception e) {
         System.out.println("Exception starting RMI registry:");
         e.printStackTrace();
      }