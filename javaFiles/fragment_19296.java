// create the JOptionPane using one of its constructors
JOptionPane optionPane = new JOptionPane("My Message", JOptionPane.PLAIN_MESSAGE);

// create a JDialog from it, tying it to the parent JFrame, here called "frame"
JDialog dialog = optionPane.createDialog(frame, "My Option");

// setting the modality type so that it is **not** modal
dialog.setModalityType(ModalityType.MODELESS); // **** key ***

// and then displaying it
dialog.setVisible(true);