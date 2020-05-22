Toolkit toolkit = Toolkit.getDefaultToolkit(); /* get AWT toolkit */

/* initialize things */
...

while (your_loop) {

  /* run your logic */
  ...

  /* paint everything */
  ...

  toolkit.sync(); /* force display buffer to flush */
}