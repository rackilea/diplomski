Composite border = new Composite(composite, SWT.BORDER); 

GridLayout layout = new GridLayout();
layout.marginHeight = 0;
layout.marginWidth = 0;
layout.marginRight = 8;  // Margin at right large enough for your decoration
border.setLayout(layout);

// Set border composite color to match Text background
border.setBackground(border.getDisplay().getSystemColor(SWT.COLOR_WHITE));

Text text = new Text(border, SWT.SINGLE);

ControlDecoration dec = new ControlDecoration(text, SWT.RIGHT | SWT.TOP, border);

dec.setImage(your image);
dec.show();