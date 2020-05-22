public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        // this is inside a "lambda" Runnable
        try {
            new StudentDirectory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
}