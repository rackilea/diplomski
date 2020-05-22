// ...
    public void startApp() {
        // extract stuff to start over into dedicated method,
        // keep the rest here
        e = new Command("Back", Command.BACK, 0);
        f = new Command("Exit", Command.EXIT, 1);
        l = new Command("List", Command.SCREEN, 3);
        mydisplay = Display.getDisplay(this);
        startOver();
    }

    public void startOver() {
        // encapsulate stuff to start over here
        final Displayable d = new CalendarCanvas(this);

        d.addCommand(f);
        d.addCommand(e);
        d.addCommand(l);
        d.setCommandListener(new CommandListener()
        {
            public void commandAction(Command c, Displayable s)
            {
                if(c == e)
                    mydisplay.setCurrent(d);
                if(c == l)
                    //mydisplay.setCurrent(mList);
                //else if(c == f)
            notifyDestroyed();
            }
        } );
        mydisplay.setCurrent(d);
    }
    // ...