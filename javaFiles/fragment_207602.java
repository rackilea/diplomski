Composite parent = new Composite(body, SWT.NONE);
parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
StackLayout layout = new StackLayout();
parent.setLayout(layout);

Composite child1 = new Composite(parent, SWT.NONE);
child1.setLayout(new GridLayout());
// TODO .... add controls to child1 for first 'page'

Composite child2 = new Composite(parent, SWT.NONE);
child2.setLayout(new GridLayout());
// TODO .... add controls to child2 for second 'page'

layout.topControl = child;
layout.layout();