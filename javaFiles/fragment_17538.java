// in the controller
def updateSystemTimeTask = new TimerTask() {
  @Override
  void run() {
    onSystemTimeUpdate System.currentTimeMillis()
  }
}

def onSystemTimeUpdate(Long systemTime) {
  if (model.working) {
    view.systemTray.trayIcons[0].toolTip = "Pracujesz już ${HourMin.since model.startedWorkingAt}".toString()
  } else {
    view.systemTray.trayIcons[0].toolTip = = "Obecnie nie pracujesz."
  }
}

// ant this in the initialization method
def myTimer = new Timer().schedule updateSystemTimeTask, initialDelay, minute