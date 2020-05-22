backspace.setOnClickListener(new View.OnClickListener() {

  public void onClick(View view) {

    sbletter = sbletter.deleteCharAt(sbletter.length - 1);

    // Now the last character from sbletter is deleted.
    // Use sbletter for whatever purpose you like now.
  }
}