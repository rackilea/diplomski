public abstract class TypedDataTable<TypeOfRow extends DataRow> extends DataTable {
  protected boolean locked;

  public TypedDataTable(DataSet ds, boolean appendRowSupported) {
    super(ds);
    InitClass();
    super.setAppendRowSupported(appendRowSupported);
    locked = false;
  }

  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
      return null;
    }
  }

 @Override
 public TypeOfRow appendRowNoEvent() {
     if (appendRowSupported) {
         TypeOfRow row = createDataRow(); //<-- HERE we create a MainDataRow!!!
         rows.add(row);
         return row;
     } else {
         return null;
     }
 }

 @Override
 public TypeOfRow appendRow() {
      return (TypeOfRow)super.appendRow();
 }

  public abstract TypeOfRow createDataRow();
  public abstract void InitVars();
  public abstract void InitClass();

  public boolean isLocked() {
    return locked;
  }

  public void setLocked(boolean locked) {
    this.locked = locked;
  }
}