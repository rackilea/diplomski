private static final int DEFAULT_SIZE = 36;

...
int fontSize = DEFAULT_SIZE;

if (small.isSelected())  fontSize = DEFAULT_SIZE - 5;     
if (medium.isSelected()) fontSize = DEFAULT_SIZE;
if (large.isSelected())  fontSize = DEFAULT_SIZE + 5;

...