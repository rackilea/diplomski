ISecurePreferences root = org.eclipse.equinox.security.storage.SecurePreferencesFactory.getDefault();
if (root == null)
return null;
ISecurePreferences node = root.node("/your.class.path.or.something.else"); // get the node for your application e.g. this.getClass().getCanonicalName()
node = node.node( "some name"); // get custom node from the tree
node.get( "key" );   // load
node.put("key","value", true / false (encrypt) ); // store (no save operation)
node.remove("key");  // remove
node.flush();        // save