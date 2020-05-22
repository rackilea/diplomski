boolean contained = false;
for (JButton j : optionButtons)
  if (j.getActionCommand().equals(e.getActionCommand()))
    contained = true;

if (contained) {
  // change room
}