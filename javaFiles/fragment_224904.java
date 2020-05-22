String[] defaultGWs = {"10.0.0.138", "10.0.0.138"};
String[] interfacesNetmasks = {"255.255.255.0", "255.255.255.0"};

for (int i = 0; i < defaultGWs.length; i++) {

    SubnetInfo subnetInfo = (new SubnetUtils(defaultGWs[i],    interfacesNetmasks[i]).getInfo());

    // CIDR signature
    String cidrSignature = subnetInfo.getCidrSignature();
    System.out.println("CIDR Signature: " + cidrSignature);

}