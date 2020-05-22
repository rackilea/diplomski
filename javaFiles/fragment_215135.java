ArrayList lastUnitNo = new ArrayList ();
for (int i=0;i<vGetExcel.size();i++){

    Vector vTableRow = (Vector)vGetExcel.elementAt(i);

    if(vTableRow.size()>=4)
    {

        String sSEQ_NO          = (String) vTableRow.elementAt(0);
        String sUNIT_NO         = (String) vTableRow.elementAt(1);
        String sOWNER_NAME      = (String) vTableRow.elementAt(2);
        String sOWNER_NAME2     = (String) vTableRow.elementAt(3);
        String sMORTGAGEE_NAME  = (String) vTableRow.elementAt(4);
        String sBANK_REF        = (String) vTableRow.elementAt(5);
        intSeqNo                = vTable.size();

        if (lastUnitNo.contains(sUNIT_NO) {
            break;
        }
        lastUnitNo.add (sUNIT_NO);

        ....
  }