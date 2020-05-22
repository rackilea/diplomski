TaskBar taskBar = Display.getDefault().getSystemTaskBar();
// TODO may return null if not supported on the platform

// Get application item

TaskItem taskItem = taskBar.getItem(null);
if (taskItem != null)
  taskItem.setOverlayText("your text");