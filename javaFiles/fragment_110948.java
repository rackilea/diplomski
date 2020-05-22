Component[] cmp=myPanel.getComponents();
for(int i=0; i<cmp.length; i++)
  if(myComponent.equals(cmp[i])) {
    myPanel.remove(myComponent);
    myPanel.add(myNewComponent, i);
  }