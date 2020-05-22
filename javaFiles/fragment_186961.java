@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application
            .showBanner(true)
            .parent(Global.class)
            .sources(applicationClass)
            .profiles("container")
            ;
}