protected Control createContents(final Composite parent) {

      parent.setSize(800, 600);

      // Main body composite
      Composite body = new Composite(parent, SWT.NONE);

      //first panel
      Composite composite = new Composite(body, SWT.NONE);
      //x, y, width, height
      composite.setBounds(10, 10, 424, 70);

      //second panel
      Composite composite_1 = new Composite(body, SWT.NONE);
      composite_1.setBounds(10, 86, 424, 309);

      //third panel
      Composite composite_2 = new Composite(body, SWT.NONE);
      composite_2.setBounds(10, 407, 424, 42);

      // Return the body
      return body;
  }