public PackageItemAdapter(List<PackageInfo> packages, PackageManager pm) {
   ArrayList<PackageItem> pis = new ArrayList<>();
   for(PackageInfo pkg : packages) {
       pis.add(new PackageItem(pkg, pkg.applicationInfo.loadLabel(pm).toString()));
   }
   mPackages = pis;
}