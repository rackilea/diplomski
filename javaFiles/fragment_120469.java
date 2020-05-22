Preferences preferences = InstanceScope.INSTANCE.getNode("<Bundle-SymbolicName>");
Preferences sub1 = preferences.node("node1");
Preferences sub2 = preferences.node("node2");
sub1.put("h1", "Hello");
sub1.put("h2", "Hello again");
sub2.put("h1", "Moin");
try {
    // forces the application to save the preferences
    preferences.flush();
} catch (BackingStoreException e) {
    e.printStackTrace();
}