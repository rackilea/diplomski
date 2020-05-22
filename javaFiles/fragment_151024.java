try {       
            URL urlServlet = new URL("uri for your servlet");
            URLConnection con = urlServlet.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestProperty(
                "Content-Type",
                "application/x-java-serialized-object");

            // send data to the servlet
            OutputStream outstream = con.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outstream);
            oos.writeObject(uuid);
            oos.flush();
            oos.close();

            // receive result from servlet
            InputStream instr = con.getInputStream();
            ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
            String name = con.getHeaderField("filename");
            File fi = new File(name);
            int i = 0;
            while ((i = inputFromServlet.read()) != -1) {
                System.out.println(inputFromServlet.readLine());
            }
            inputFromServlet.close();
            instr.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }