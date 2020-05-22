if(Gesture.hasGestures) // only load for mobile devices
    {
        $(RootPanel.get())
                .as(Gesture.Gesture)
                .on("tap", new Function() 
                {
                    @Override
                    public boolean f(Event e)
                    {
                        Log.info("tap:" + e.getType() + ", x:" + e.getClientX() + ", y:" + e.getClientY());

                        return true;
                    }
                })
                .on("swipeone", new Function()
                {
                    @Override
                    public boolean f(Event e)
                    {
                        GestureObjects.Options o = arguments(0);
                        int delta = (int) o.delta().get(0).moved();

                        Log.info(o.description() + ":" + o.directionName() + ", x:" + e.getClientX() + ", y:" + e.getClientY() + ", delta:" + delta);

                        return true;
                    }

                });
    }
    else
    {
        Log.info("Not adding gesture handlers as this is not a mobile device!");
    }