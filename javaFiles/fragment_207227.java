Process croppingProcess =  Runtime.getRuntime()
                .exec("C:\\Windows\\System32\\cmd.exe /C Start C:\\restapi_bat\\echot ");
                int processOutput = croppingProcess.waitFor();
                if(processOutput == 0){
                    success = true;
            //do your work here
        }