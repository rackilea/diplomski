JButton button = new JButton(str);
Font font = button.getFont();
int failingIndex = font.canDisplayUpTo(str);
if (failingIndex >= 0) {
  // failingIndex points to the first codepoint in your string that cannot be represented with the font.
} else {
  // This string can be displayed with the given font.
}