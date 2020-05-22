public void actionPerformed(ActionEvent e) {
  Object source = e.getSource();

  // Find out which component fired the event
  if (source == masterButton) {
    // ... do something
  } else if (source == anotherButton) {
    // ... do something else
  } else if (...)
    // ... and so on ...
  } else if (...)
    // ... and so on ...
  }
}