// Configuration
String vmIp = "vm-ip";
String vmSshUsername = "root";
String vmSshPassword = "foo";

String endpoint = "https://mychefserver.example.com";
String client = "myuser";
String validator = "chef-validator";
String clientCredential = Files.toString(new File("/home/myuser/.chef/myuser.pem"), Charsets.UTF_8);
String validatorCredential = Files.toString(new File("/home/myuser/.chef/chef-validator.pem"), Charsets.UTF_8);

Properties props = new Properties();
props.put(ChefProperties.CHEF_VALIDATOR_NAME, validator);
props.put(ChefProperties.CHEF_VALIDATOR_CREDENTIAL, validatorCredential);
props.put(Constants.PROPERTY_RELAX_HOSTNAME, "true");
props.put(Constants.PROPERTY_TRUST_ALL_CERTS, "true");

/* *** First, create the context to connect to the Chef Server *** */

// Create the context and configure the SSH driver to use. sshj in this example
ChefContext ctx = ContextBuilder.newBuilder("chef")
    .endpoint(endpoint)
    .credentials(client, clientCredential)
    .overrides(props)
    .modules(ImmutableSet.of(new SshjSshClientModule())) //
    .buildView(ChefContext.class);
CherService chef = ctx.getChefService();

/* *** Second, generate the bootstrap script *** */

// Generate the bootsrap configuration
List<String> runlist = new RunListBuilder().addRole("typicalapp").build();
BootstrapConfig bootstrapConfig = BootstrapConfig.builder().runlist(runlist).build();

// Generate the bootstrap script to be executed in the VM (this will persist
// the configuration in a data bag under the key 'jclouds-chef' so it can be reused
// and then build the bootstrap script with the information in the configuration data bag)
chef.updateBootstrapConfigForGroup("jclouds-chef", bootstrapConfig);
Statement bootstrap = chef.createBootstrapScriptForGroup("jclouds-chef");

/* *** Finally create an SSH connection manually and run the script on the VM *** */

SshClient.Factory sshFactory = ctx.unwrap().utils()
    .injector().getInstance(Key.get(new TypeLiteral<SshClient.Factory>() {}));
SshClient ssh = sshFactory.create(HostAndPort.fromParts(vmIp, 22),
    LoginCredentials.builder().user(vmSshUsername).password(vmSshPassword).build());

ssh.connect();
try {
    String rawScript = bootstrap.render(OsFamily.UNIX);
    ExecResponse result = ssh.exec(rawScript);
} finally {
    ssh.disconnect();
}