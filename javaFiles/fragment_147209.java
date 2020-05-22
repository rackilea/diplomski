cmdArg[0] = "/usr/local/ssl/bin/openssl";
cmdArg[1] = "x509";
cmdArg[2] = "-in";
cmdArg[3] = certFilePAth;
cmdArg[4] = "-noout"
cmdArg[5] = "-text";
cmdArg[6] = "-certopt";
cmdArg[7] = "no_subject,no_header,no_version,no_serial,no_validity," +
            "no_issuer,no_pubkey,no_sigdump,no_aux,no_extensions ";