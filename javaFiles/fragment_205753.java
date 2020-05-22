public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==search){
data=get();

        for(int i=0;i<count;i++){
        Object[] d={data.get(i).get(0),data.get(i).get(1),data.get(i).get(2)};
        model.addRow(d);
}
}
    }