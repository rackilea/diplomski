// Init to safe state
print("\n\n");
for (loop conditions here) {
  print(ANSI_CSI + "2A"); // Up 2
  print(ANSI_CSI + "K");  // Clear
  println(text_a);        // Print + newline
  print(ANSI_CSI + "K");  // Clear
  println(text_b);        // Print + newline
  Thread.sleep(3000);     // Wait
}