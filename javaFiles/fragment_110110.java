Pattern.<DoorEvent>begin("first")
        .where(new SimpleCondition<DoorEvent>() {
          private static final long serialVersionUID = 1390448281048961616L;

          @Override
          public boolean filter(DoorEvent event) throws Exception {
            return event.getDoor().getStatus().equals("open");
          }
        })
        .followedBy("second")
        .where(new IterativeCondition<DoorEvent>() {
          private static final long serialVersionUID = -9216505110246259082L;

          @Override
          public boolean filter(DoorEvent secondEvent, Context<DoorEvent> ctx) throws Exception {

            if (!secondEvent.getDoor().getStatus().equals("close")) {
              return false;
            }

            for (DoorEvent firstEvent : ctx.getEventsForPattern("first")) {
              if (secondEvent.getDoor().getEventID().equals(firstEvent.getDoor().getEventId())) {
                return true;
              }
            }
            return false;
          }
        })
        .within(Time.minutes(5));