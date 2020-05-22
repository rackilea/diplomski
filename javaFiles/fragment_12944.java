// String zeichen;
System.out.println("Bitte geben Sie einen Text ein: ");
if (sc.hasNextLine()) { // <--- while to get multiple lines. if for one line.
   String str = sc.nextLine();
  // if (str.equalsIgnoreCase("quit")) { // <-- possibly, if you want multiple
  //                                     // lines.
  //   break;
  // }
  st.push(str);
}