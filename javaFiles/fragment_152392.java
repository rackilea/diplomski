String command_ping = "ping " + host_name;

            try {

                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command_ping);
                builder.redirectErrorStream(true);
                Process p = builder.start();

                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while (true) 
                {

                    buffer.append(line).append("\n");
                    line = r.readLine();
                    if (line == null) { break; }
                }
                message_ping= buffer.toString();
                p.waitFor();
                r.close();

            } 

            catch (IOException e) 
            {
                e.printStackTrace();
            } 

            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }