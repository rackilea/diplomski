OutputStream outs = response.getOutputStream();
                outputToApplet = new ObjectOutputStream(outs);
                int i = 0;
                while ((i = in.read()) != -1) {
                    outputToApplet.write(i);
                }