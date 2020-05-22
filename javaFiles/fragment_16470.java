@Override
  public void dispatchEvent(Event event) {
      checkNotNull(event);

      CancellableEvent cancellableEvent = null;
      boolean cancellable;
      if (cancellable = event instanceof CancellableEvent) {
          cancellableEvent = (CancellableEvent) event;
          checkArgument(cancellableEvent.isCancelled());
      }

     fireEvents(false, event, cancellableEvent, cancellable);
     fireEvents(true, event, cancellableEvent, cancellable);

  }

  private void fireEvents(boolean considerCancellation, Event event, CancellableEvent cancellableEvent, boolean cancellable)
  {
     // Event handlers that consider cancellation will run
     for (EventPriority priority : EventPriority.values()) {
         Map<Method, EventListener> internalMapping = getRegistry().getMethodMap(event.getClass(), priority, ! considerCancellation);
         if (internalMapping != null) {
             for (Map.Entry<Method, EventListener> entry : internalMapping.entrySet()) {
                 try {
                     entry.getKey().invoke(entry.getValue(), event);
                 } catch (IllegalAccessException e) {
                     e.printStackTrace();
                 } catch (IllegalArgumentException e) {
                     e.printStackTrace();
                 } catch (InvocationTargetException e) {
                     /*
                      * Delegate any exceptions that occur from
                      * the method to a runtime exception.
                      */
                     throw new RuntimeException(e);
                 }
                 // Immediately return in the case of the event being cancelled.
                 if ( considerCancellation && cancellable && cancellableEvent.isCancelled()) {
                     return;
                 }
             }
         }
     }
  }