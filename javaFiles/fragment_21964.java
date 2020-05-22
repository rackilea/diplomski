viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

// ...

if (id == R.id.nav_favourite) {
    viewFlipper.setDisplayedChild(0);
    setTitle("Favourites");
} else if (id == R.id.nav_search) {
    viewFlipper.setDisplayedChild(1);
    setTitle("Search");
}