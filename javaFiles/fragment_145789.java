ArrayList<JButton> list=new ArrayList<>();
int numOfButtons = 10;
for (int i = 0; i < numOfButtons; i++){
    JButton jb=new JButton("" + i);
    list.add(jb);
    add(jb);
}