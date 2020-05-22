Compiled from "FilePermission.java"
public final class java.io.FilePermission extends java.security.Permission implements java.io.Serializable {
  public transient java.lang.String cpath;
  public java.io.FilePermission(java.lang.String, java.lang.String);
  java.io.FilePermission(java.lang.String, int);
  public boolean implies(java.security.Permission);
  boolean impliesIgnoreMask(java.io.FilePermission);
  public boolean equals(java.lang.Object);
  public int hashCode();
  int getMask();
  public java.lang.String getActions();
  public java.security.PermissionCollection newPermissionCollection();
  static java.lang.String access$000(java.io.FilePermission);
}