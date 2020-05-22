function onExit() {
  if [[ "$saved_stty" != "" ]]; then
    restoreSttySettings
  fi
  exit $scala_exit_status
}