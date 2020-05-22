path1 = Paths.get("/var");
path2 = Paths.get("/tmp");

path3 = path1.relativize(path2);  // path3 is "../tmp"
path4 = path1.resolve(path3);     // path4 is "/var/../tmp"

path5 = path4.normalize();        // path5 is "/tmp"