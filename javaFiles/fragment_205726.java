Map<String,String> values=new HashMap<>();
.
.
.
String[] columns ={"greek legend","minataur"};
for(int i=0;i<columns.length;i++){
    String val=values.get(columns[i]);
    if(val!=null)
    {
        //put value in cell
    }
    else{
        //add blank cell
    }
}