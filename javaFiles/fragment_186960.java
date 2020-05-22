@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application
            .showBanner(true)
            .parent(Global.class)
            .child(applicationClass)
            .profiles("container")
            ;
}