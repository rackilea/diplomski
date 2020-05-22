while(EsperarConexiones){ 

            Socket socket = listener.accept(); //<-- fix HERE

            Panel_mensajes.MostrarMensaje("NUEVA CONEXION " + 
                    socket.getInetAddress().toString().replace("/", "") + ":" 
                    + socket.getPort() + ", "
                    + fecha.getTime() + "\n" + "\n"
                );

            ManejoConexion con_nva = new ManejoConexion(socket);
            iniciarThread.execute(con_nva);
        }