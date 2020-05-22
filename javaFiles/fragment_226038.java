peList.add(pe);

// fix order values and spaces-in-path quoting
int i = 0;
for (IProtectionEntry pe : peList) {

    pe.setOrder(i++);

    if (pe.getPath().indexOf(" ") >= 0) {
        // this bug should be fixed in 2014.X (no promises) 
        if (pe.isPathExcluded()) {
            pe.setPath("\"-" + pe.getPath() + "\"");
            pe.setPathExcluded(false);
        } else {
            pe.setPath("\"" + pe.getPath() + "\"");
        }
    }
}

try {
    String createProtectionEntries = server.createProtectionEntries(peList);