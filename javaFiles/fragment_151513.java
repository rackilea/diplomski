try {
    process(....)
} catch (UserException ex) (
   showMessage(ex.getMessage());
) catch (PresentationError ex) {
  log.fatal(ex.getMessage());
  showMessage("Pre-formatted internal error message");
} catch (Exception ex) { //Unknown exception
  log.fatal(ex.getMessage());
  showMessage("Pre-formatted internal error message");
}