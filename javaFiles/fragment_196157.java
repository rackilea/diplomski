while (cont) {

  // getInt() is the troublemaker, so we try it:
  // Notice I have changed 'number' to 'integer' here - this improves
  // UX by prompting the user for the data type the program expects:

  try {
    printb(convert(getInt(in, "Enter an integer: ")));
  }

  // we catch the Exception and name it. 'e' is a convention but you
  // could call it something else. Sometimes we will use it for info,
  // and in this case we don't really need it, but Java expects it
  // nonetheless.
  // We do our error handling here: (notice the call to in.next() -
  // this ensures that the string that was entered gets properly
  // handled and doesn't cascade down to the assignment of 'a') - if
  // this confuses you, try it without the in.next() and see what
  // happens!

  catch (Exception e) {
    System.out.println("\nPlease enter an integer.\n");
    in.next();
  }

  // Again, in this case, the finally isn't necessary, but it can be
  // very handy, so I'm using it for illustrative purposes:

  finally {
    System.out.println("Do you want to continue (yes or no)?");
    a = in.next();
    if (a.equals("yes")) {
      cont = true;
    } else {
      System.out.println("You answered no. Have a nice day.");
      cont = false;
    }
  }
}