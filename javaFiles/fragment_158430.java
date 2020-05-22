String[] systemPackages = new String[]{<all names of the packages>};
Package[] pa = Package.getPackages();
int n = 0;

for (int i = 0; i < pa.length; i++) {
    Package p = pa[i];
    boolean isSystemPackage = false;
    String pname = p.getName();
    for (int j = 0; j < systemPackages.length; j++) {
        String spname = systemPackages[j];
        if (pname.equals(spname)) {
            isSystemPackage = true;
            systemPackages[j] = null;
            break;
        }
    }
    if (!isSystemPackage) {
        n++;
    } else {
        pa[i] = null;
    }
}

Package[] projectPackages = new Package[n];
for (int i = 0, j = 0; i < pa.length; i++) {
    Package p = pa[i];
    if (p != null) {
        projectPackages[j] = p;
        j++;
    }
}