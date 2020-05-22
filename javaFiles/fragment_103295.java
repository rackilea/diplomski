WLAN_INTERFACE_INFO_LIST(Pointer p) {
    super(p);
    this.dwNumberOfItems = p.readInt(0);
    this.InterfaceInfo = new WLAN_INTERFACE_INFO[this.dwNumberOfItems];
    read();
}