[... line 443]
Enumeration<URL> sec = super.getResources(name);
while (sec.hasMoreElements()) {
    URL item = sec.nextElement();
    if (!inOwnBase(item, name)) vector.add(item); // <<-- HERE
}

if (altName != null) {
    Enumeration<URL> tern = super.getResources(altName);
    while (tern.hasMoreElements()) {
        URL item = tern.nextElement();
        if (!inOwnBase(item, altName)) vector.add(item); // <<-- AND HERE
    }
}