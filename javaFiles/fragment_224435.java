final Container c = (Container) container;
    final AtomicReference<Object[]> result = new AtomicReference<>();
    try {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                result.set(c.getComponents());
            }
        });
    } catch (Exception e) {
         throw new RuntimeException(e.getMessage(), e);
    }
    Object[] components = result.get();
    Vector componentVector = Utils.convertArrayToVector(components);