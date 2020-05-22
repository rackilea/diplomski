if (System.getProperty("os.name").contains("Win")) {
  infacmdListLicensesCommand = env.get("INFA_HOME") + "/isp/bin/infacmd.bat ListLicenses -dn " +
                               params.get("dn") + " -un " + params.get("un") + " -pd " +
                               params.get("pd") + " -sdn " + params.get("sdn") + " -hp " +
                               params.get("dh") + ":" + params.get("dp")
}
else {
  infacmdListLicensesCommand = env.get("INFA_HOME") + "/isp/bin/infacmd.sh ListLicenses -dn " +
                               params.get("dn") + " -un " + params.get("un") + " -pd " +
                               params.get("pd") + " -sdn " + params.get("sdn") + " -hp " +
                               params.get("dh") + ":" + params.get("dp")
}