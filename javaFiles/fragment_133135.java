String[] type = {"Laptop", "Notebook", "Portable", "Sub Notebook"};

            ....

            String cmd1[] = {"/bin/sh","-c","lsb_release -a | grep -i Description"};
            Runtime runsv = Runtime.getRuntime();
            Process prsv = runsv.exec(cmd1);
            BufferedReader sv = new BufferedReader(new InputStreamReader(
                    prsv.getInputStream()));
            String line1;
            while ((line1 = sv.readLine()) != null) {
                server = line1;

            }

            String cmd = "sudo dmidecode --string chassis-type";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            BufferedReader comt = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = comt.readLine()) != null) {
                getcomputerType = line;
            }
            if (getcomputerType.equals(type)) {
                compType = "2";
            } else {
                if (server.equals("Server")) {
                compType = "3";
                }
                else{
                    compType = "1";
                }
            }