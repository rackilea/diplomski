boolean k = false;
String trf = JOptionPane.showInputDialog("Insert [ID <space> Amount]:");
StringTokenizer tr = new StringTokenizer(trf);
tid = tr.nextToken();
int tam = Integer.parseInt(tr.nextToken());
for(int x=0;x<4;x++){
    if (t[x].account.getId().equals(tid)){
       k = true;
       //transfer code here[...]
       break;
    }
}
if(!k){
   JOptionPane.showMessageDialog(null, "ID not found");
}