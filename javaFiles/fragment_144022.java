ActionBar bar = getSupportActionBar();
if( bar != null ) {
    // remove back arrow
    bar.setDisplayHomeAsUpEnabled( false );
    bar.setDisplayShowTitleEnabled( true );
}