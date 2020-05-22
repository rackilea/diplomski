clearTimeout(timer);

if(button.g == 0) {
    f.a(parent);
    AutoJoin.instance.resetCache();
} 
else if if(button.g == 1) {
    AutoJoin.instance.screen = new AutoJoinScreen(parent, info);
    f.a(AutoJoin.instance.screen);
}
else if(button.g == 2) {
    f.a(new PropertiesScreen(this, info.ip));
}