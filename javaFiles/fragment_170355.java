System.out.println("Waiting for connect to client");
             s1=serverSocket.accept();


             s1In = s1.getInputStream();
             dis = new DataInputStream(s1In);

             out=s1.getOutputStream();
             dos=new DataOutputStream(out);