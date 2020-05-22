public class InsertFileToJtable extends AbstractTableModel{
 Vector data;
-Vector columns;
+int columnCount;
⋮
 data = new Vector();
-columns = new Vector();
+coumnCount = 0;
⋮
-        while (st1.hasMoreTokens())
-                columns.addElement(st1.nextToken());
+        while (st1.hasMoreTokens()) {
+                data.addElement(st1.nextToken());
+                ++coumnCount;
+        }
⋮
 public int getColumnCount() {
-return columns.size();
+return coumnCount;
 }