while(true){

                    try{
                            byte[] buf = new byte[2048];

                            DatagramPacket packet = new DatagramPacket( buf, buf.length, address );

                            socket.receive( packet );
                            threadPool.execute( new Request( this, socket, packet ));

           .......