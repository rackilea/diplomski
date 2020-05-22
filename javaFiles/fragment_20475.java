public DoomMain()
{
    // Open screen here since we need a context to make textures etc
    ...
    // Make objects for your different parts
    MainMenu menu = MainMenu();
    menu.loadData(); // <- Loads the texture and font

    while(!Display.isCloseRequested())
    {                           
        state = State.MENU;     
        switch(state) {
            ...
            case MENU:
                menu.draw();
                break;
            ...
        }
        Display.update();
        Display.sync(60);
    }
    Display.destroy();
}