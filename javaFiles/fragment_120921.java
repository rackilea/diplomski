for (Window window : WindowManager.getDefault().getMainWindow().getOwnedWindows())
{
    // Close and dispose the dialog 
    window.setVisible(false);
    window.dispose();
}