// get node "config/plugin.id"
// note: "config" identifies the configuration scope used here
final Preferences preferences = ConfigurationScope.INSTANCE.getNode("plugin.id");

// set key "a" on node "config/plugin.id"
preferences.put("a", "value");

// get node "config/plugin.id/node1"
final Preferences connections = preferences.node("node1");

// remove all keys from node "config/plugin.id/node1"
// note: this really on removed keys on the selected node
connections.clear();

// these calls are bogous and not necessary
// they get the same nodes as above
//preferences = ConfigurationScope.INSTANCE.getNode("plugin.id");
//connections = preferences.node("node1");

// store some values to separate child nodes of "config/plugin.id/node1"
for (Entry<String, ConnectionDetails> e : valuesToSave.entrySet()) {
    String name = e.getKey();
    ConnectionDetails d = e.getValue();
    // get node "config/plugin.id/node1/<name>"
    Preferences connection = connections.node(name);
    // set keys "b" and "c"
    connection.put("b", d.getServer());
    connection.put("c", d.getPassword());
}

// flush changes to disk (if not already happend)
// note: this is required to make sure modifications are persisted
// flush always needs to be called after making modifications
preferences.flush();