StringBuilder sb = new StringBuilder();

for (int i=0;i<16;i++) {
  ...

switch (count % 4) {
  case 0 : 
    sb.append(verbs.get(random).toString() + "\n");
    break;
  case 1 :
    sb.append(adverbs.get(random).toString() + " ");
    break;

  ....
  JOptionPane.showMessageDialog(null, sb.toString());