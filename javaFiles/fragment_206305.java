boolean isWindows = System.getProperty("os.name").contains("Win")
// Do it as a list of 3 items for formatting purposes
infacmdListLicensesCommand = [
  "$env.INFA_HOME/isp/bin/infacmd.${isWindows?'bat':'sh'} ListLicenses"
  "-dn $params.dn -un $params.un -pd $params.pd -sdn $params.sdn"
  "-hp $params.dh:$params.dp" ].join( ' ' ) // then join them back together

println infacmdListLicensesCommand // print it out to see it's the same as before