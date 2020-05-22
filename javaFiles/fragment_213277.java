try 
        {
            Toast.makeText(context,"IP: "+ip+" port: "+port,10000).show();
            InetAddress serverAddr = InetAddress.getByName(ip); 
            socket = new Socket(serverAddr, port);
        } 
        catch (UnknownHostException e1) 
        {
            Toast.makeText(context,"UnknownHostException ",10000).show();
        } 
        catch (IOException e1) 
        {
            Toast.makeText(context,"IOException ",10000).show();
        }

        String message = "HELLO FROM CLIENT";

        PrintWriter out = null;
        BufferedReader in = null;

        try { 
            Log.d("TCP", "C: Sending: '" + message + "'"); 

            /*write*/
            OutputStream ostr=socket.getOutputStream();
            OutputStreamWriter outputstr=new OutputStreamWriter(ostr);
            BufferedWriter buffw=new BufferedWriter(outputstr);
            out = new PrintWriter(buffw ,true);
            out.println("HELLO 1 FROM CLIENT");

            /*read - i modify to this*/
            InputStreamReader reader=new InputStreamReader(socket.getInputStream());
            char[] bytesreceived=new char[50];
            reader.read(bytesreceived    , 0, 50);
            String text="";
            for (int i=0;i<bytesreceived.length;i++)
            {
                text+=bytesreceived[i];
            }
            Toast.makeText(context, "Received1: "+text.trim(), 10000).show();
            Log.d("IdealLog","Received1: "+text.trim());

            /*write*/
            out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
            out.println("HELLO 2 FROM CLIENT");

            /*read*/
            reader=new InputStreamReader(socket.getInputStream());
            bytesreceived=new char[50];
            reader.read(bytesreceived    , 0, 50);
            text="";
            for (int i=0;i<bytesreceived.length;i++)
            {
                text+=bytesreceived[i];
            }
            Toast.makeText(context, "Received2: "+text.trim(), 10000).show();
            Log.d("IdealLog","Received2: "+text.trim());

        } catch(Exception e) { 
            Log.e("TCP", "S: Error", e); 
        } finally { 
            try {
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }