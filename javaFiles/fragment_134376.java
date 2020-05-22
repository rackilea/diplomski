interface Showable {
    void show();
}
map() {

    map.put("p1", new Showable() { void show() { new Popup1().show(); } } );
    map.put("p2", new Showable() { void show() { new Popup2().show(); } } );
    map.put("p3", new Showable() { void show() { new Popup3().show(); } } ); 
}

onValueChange() {
    map.get(selectedItem).show();
}