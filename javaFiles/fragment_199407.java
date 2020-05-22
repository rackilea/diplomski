// If we are at the end of input then NoSuchElement;
  903     // If there is still input left then InputMismatch
  904     private void throwFor() {
  905         skipped = false;
  906         if ((sourceClosed) && (position == buf.limit()))
  907             throw new NoSuchElementException();
  908         else
  909             throw new InputMismatchException();
  910     }