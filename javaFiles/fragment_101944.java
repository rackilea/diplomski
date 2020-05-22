strSQLString = "SELECT tblExportCost.ProjDef, tblExportCost.Year,\n"
                        + "Sum(IIf([Per]=1,[Val/ObjCur],0.0)) AS Jan, Sum(IIf([Per]=2,[Val/ObjCur],0.0)) AS Feb, Sum(IIf([Per]=3,[Val/ObjCur],0.0)) AS Mar,\n"
                        + "Sum(IIf([Per]=4,[Val/ObjCur],0.0)) AS Apr, Sum(IIf([Per]=5,[Val/ObjCur],0.0)) AS May, Sum(IIf([Per]=6,[Val/ObjCur],0.0)) AS Jun,\n"
                        + "Sum(IIf([Per]=7,[Val/ObjCur],0.0)) AS Jul, Sum(IIf([Per]=8,[Val/ObjCur],0.0)) AS Aug, Sum(IIf([Per]=9,[Val/ObjCur],0.0)) AS Sep,\n"
                        + "Sum(IIf([Per]=10,[Val/ObjCur],0.0)) AS Oct, Sum(IIf([Per]=11,[Val/ObjCur],0.0)) AS Nov, Sum(IIf([Per]=12,[Val/ObjCur],0.0)) AS Dec\n" 
                        + "FROM tblExportCost\n" 
                        + "GROUP BY tblExportCost.ProjDef, tblExportCost.Year\n" 
                        + "HAVING (((tblExportCost.Year)= '" + strYear + "') AND ((tblExportCost.ProjDef)= 'T3415" + strNumber + "'))";