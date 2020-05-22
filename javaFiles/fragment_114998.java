try {
    final Process calc = Runtime.getRuntime().exec("calc");
    if (calc.waitFor() == 0) {
        JOptionPane.showMessageDialog(null, "Program has been closed successfully.", "Program closed", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Program has been closed unsuccessfully.", "Program closed", JOptionPane.WARNING_MESSAGE);
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(null, "IO error: " + e.getMessage(), "Exception encountered", JOptionPane.ERROR_MESSAGE);
} catch (InterruptedException e) {
    JOptionPane.showMessageDialog(null, "Thread interrupted: " + e.getMessage(), "Exception encountered", JOptionPane.ERROR_MESSAGE);
}