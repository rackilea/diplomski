public void onEnable(){
    ...
    for(Arena arena : manager.getAllArenas()){
        arena.onEnable();
    }
    ...
    foo();
}