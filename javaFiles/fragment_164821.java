File[] images = dir.listFiles( new FileFilter() {
    @Override
    public boolean accept( File pathname ) {
        String name = pathname.getName();
        return name.endsWith( ".png" ) || name.endsWith( ".jpg" );
    }
} );