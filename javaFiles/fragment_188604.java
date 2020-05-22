} catch (IOException ioe) {
        // Here print the ioe stack trace to whenever you want and check why you get this exception.

    } catch (IllegalArgumentException ioe) {
        JOptionPane.showMessageDialog(RunFrame.getInstance(),
                "Could not open connection to Banners Broker!",
                "Error",
                JOptionPane.ERROR_MESSAGE);