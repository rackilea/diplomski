IconClick onClick = (Player p, Icon i, InventoryClickEvent e) -> {
     // some logic in here
     return false; // must return 'false' or 'true' 
};

Icon icon = new Icon().setOnClick((p, i, e) -> false); // or 'onClick'