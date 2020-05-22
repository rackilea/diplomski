@Bean
@Scope("prototype")
CmdArgs cmdArgs() {
    return new CmdArgs();
}

@Bean
@Scope("prototype")
OozieJobFactory oozieJobFactory() {
    return new OozieJobFactory();
}

@Bean
OozieJob oozieJob(OozieJobFactory factory, CmdArgs cmdArgs) {
    return factory.createJob(cmdArgs);
}