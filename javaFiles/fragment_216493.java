if (StompCommand.ERROR.equals(command)) {
            try {
                session.close(CloseStatus.PROTOCOL_ERROR);
            }
            catch (IOException ex) {
                // Ignore
            }
        }