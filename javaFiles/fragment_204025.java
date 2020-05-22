List<PkgLoad> packages = new ArrayList<PkgLoad>();
packages.add( new PkgLoad( 24.3, 6 ) );
packages.add( new PkgLoad( 45.3, 5 ) );
packages.add( new PkgLoad( 23.3, 4 ) );
...
String json = new JSONSerializer().serialize( packages, "aaData" );