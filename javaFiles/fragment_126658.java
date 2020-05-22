if (e.getSource() == textA){
   transfer = String.format("field 1 : %s", e.getActionCommand());
   double a = Integer.parseInt(transfer);
   GUISource.a = a;
}
//similarly for b and c