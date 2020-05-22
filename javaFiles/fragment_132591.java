Object data = model.getValueAt(I, j);

if (data == null)
    System.out.println("null data at - " + I + " : " + j);
else
    bw.write( data.toString() );