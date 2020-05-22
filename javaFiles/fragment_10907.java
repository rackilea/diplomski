public class WorkForce extends Fragment implements DataUpdate {
...
  private WorkData workData; // this fragment's "copy" of the data
...
@Override
public WorkData getData() {
  this.workData.subCon = this.subCon; // Assuming subcon has been updated.. else use txt1.getText();
  return this.workData;
}

@Override
public void setData(WorkData workData) {
 this.workData = workData;
 // Update this page's views with the workData...
 // This assumes the fragment has already been created and txt1 is set to a view
 txt1.setText(workData.subCon);
 this.subCon = workData.subCon; // Actually could just use subCon in workData, but be aware that workData actually points to the Activity's copy (kinda makes getdata redundant.. but I like symmetry and couldn't be bothered making lots of copies of the object).
}