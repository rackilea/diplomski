try
        {
            Vars.mediaSocket.setSendBufferSize(outputBufferSize);
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }