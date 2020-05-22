public static void main(final String [] args)
{
  // Create the display
  Display display = new Display();

  ReservationWizard wizard = new ReservationWizard();
  WizardDialog dialog = new WizardDialog(display.getActiveShell(), wizard);

  dialog.setBlockOnOpen(true);
  dialog.open();
}