function onExit() {
  if [[ "$saved_stty" != "" ]]; then
    restoreSttySettings
    exit $scala_exit_status
  fi
}