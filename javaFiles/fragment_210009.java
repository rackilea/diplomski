String cmd="C:\\Informatica\\9.6.1\\clients\\PowerCenterClient\\CommandLineUtilities\\PC\\server\\bin\\pmcmd.exe";
                final Process cmdProcess;

                cmdProcess = Runtime.getRuntime().exec(new String[]{cmd,""});
                OutputStream out = cmdProcess.getOutputStream();
                out.write("connect  -sv IS_NAME -d DOMAIN_NAME -u USER -p PWD".getBytes());
                out.close;