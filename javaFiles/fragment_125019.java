// If user typed the 'bye' command, wait until the server closes
            // the connection.
            if ("bye".equals(line.toLowerCase())) {
                ch.closeFuture().sync();
                break;
            }
        }
        //this is for safety reasons, it is optional-ish

        // Wait until all messages are flushed before closing the channel.
        if (lastWriteFuture != null) {
            lastWriteFuture.sync();
        }
      //what you already have
    } finally {
        // The connection is closed automatically on shutdown.
        group.shutdownGracefully();
    }
}