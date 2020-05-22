@Entity
@IdClass(PermissionPk.class)
public class Permission{

   @Id
   private String id;

// for the next 3 fields there are no public acessors, so the public API of the class was not changed !
   @Id
   @Column(name = "PROJECT")
   private String projectId;

   @Id
   @Column(name = "PERMISSIONCONTEXTTYPE")
   private String permissionContextTypeId;

   @Id
   @Column(name = "PERMISSIONCONTEXT")
   private String permissionContextId;


   @JoinColumns ({
            @JoinColumn (name = "PROJECT", referencedColumnName = "PROJECT", updatable = false, insertable = false),
            @JoinColumn (name = "PERMISSIONCONTEXTTYPE", referencedColumnName = "PERMISSIONCONTEXTTYPE", updatable = false, insertable = false),
            @JoinColumn (name = "PERMISSIONCONTEXT", referencedColumnName = "ID", updatable = false, insertable = false)
        })
   @ManyToOne
   private PermissionContext permissionContext;

   public static class PermissionPk implements Serializable{      
// previously they where private as well, but removed public constructor for the sake of simplicity of the question - so no changes where necesary in public API of the class !
      private String id;        
      private String projectId;        
      private String permissionContextTypeId;
      private String permissionContextId;

   public PermissionPk () {}

    public PermissionPk (String aId, PermissionContextPk aPermissionContext) {
        this.id = aId;
        permissionContextId = aPermissionContext.id;
        permissionContextTypeId = aPermissionContext.permissionContextType.id;
        projectId = aPermissionContext.permissionContextType.project;
    }  
... eq and hashCode here ...
   }
}