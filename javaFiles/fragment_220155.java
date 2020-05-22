Resource   rootRc = root.eResource();
String     rcPath = rootRc.getURI().toPlatformString( true );
IFile      file   = (IFile)ResourcesPlugin.getWorkspace().getRoot().findMember( rcPath );
IContainer parent = file.getParent();
for( IResource member : parent.members())
{
   String ext = member.getFileExtension();
   if( ext != null && ext.equals( "types" ))
   {
      String prefix     = member.getName();
      String path       = member.getLocation().toString();
      URI    uriSibling = URI.createFileURI( path );
      prefix = prefix.substring( 0, prefix.length() - ".types".length());
      if( ! rcPath.endsWith( '/' + prefix + ".types" )
         && ( context.getPrefix().isEmpty() || prefix.startsWith( cntxtPrefix )))
      {
         Resource types  = rs.createResource( uriSibling );
         types.load( null );
         for( EObject rc : types.getContents())
         {
            ...
         }
      }
   }
}