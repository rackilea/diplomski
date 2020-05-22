public class MyEntityAuditListener extends AbstractAuditListener {
    @Override
    public boolean onPostUpdate(EnversPostUpdateEvent event) {
      // return true = allow the audit operation
      // return false = veto the audit operation
      if ( event.getPropertyChangeCount() != 1 ) {
        return true;
      }
      return !event.isPropertyChanged( "mySpecialString" );       
    }
}

@Entity
@Audited
@AuditListener(MyEntityAuditListener.class)
public class MyEntity {
  // ...
  private string mySpecialString;
}