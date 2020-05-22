} catch (IOException ioe) {
} catch (IllegalArgumentException ioe) {
    JOptionPane.showMessageDialog(RunFrame.getInstance(),
            "Could not open connection to Banners Broker!",
            "Error",
            JOptionPane.ERROR_MESSAGE);