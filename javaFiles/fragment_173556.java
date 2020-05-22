String[] csrCmd = {
    "openssl",
    "req",
    "-new",
    "-key",
    path+name + ".key",
    "-out",
    path+name + ".csr",
    "-subj",
    "/C=PK/ST=Sindh/L=Karachi/O=Company Pvt Ltd/OU=IT Department/CN=Developer"
};

Process p2 = Runtime.getRuntime().exec(csrCmd);