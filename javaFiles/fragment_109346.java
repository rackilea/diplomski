private void updateProgress(final JPanel visualizza) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            display.add(visualizza, BorderLayout.SOUTH);
            display.revalidate();
            display.repaint();
        }
    });
}}