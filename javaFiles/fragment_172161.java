public Restaurant add(Menu menu) {
    this.menus.add(menu);
    return this;
}

public Restaurant(String name) {
    this.name = name;
}

public List<Menu> getMenus() {
    return menus;
}