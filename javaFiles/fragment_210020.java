int lastOverDue = -1;
int i = 0;
while (i < dairy.length && Today.after(dairy[i].getDue_Date()) ) {
  lastOverDue++;
  i++;
}