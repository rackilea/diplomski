MenuBar mymenubar = new MenuBar(true);
            for(final String string : myListOfStrings){

                MenuItem menuItem = new MenuItem(string , new Command() {
                    @Override
                    public void execute() {
                         //Do some thing on each menu
                    }
                });

                mymenubar .addItem(menuItem);
            }