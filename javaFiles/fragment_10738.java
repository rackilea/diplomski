public MyApplicationContext(String xml,
        ApplicationContext parent){

    super(parent);

    this.configResources = new Resource[1];

    configResources[0] = new ByteArrayResource(xml.getBytes());


    refresh();
}


private Resource[] configResources;

protected Resource[] getConfigResources() {
    return this.configResources;
}