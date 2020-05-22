if(item.title != null && !item.title.isEmpty()) {
    // Yay, we have something useful!
    a1.title = item.title.trim();
} else {
    // Perhaps we should give a default value?
    a1.title = "";
}