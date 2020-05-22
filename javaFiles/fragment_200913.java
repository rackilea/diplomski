Iterator<VendorItem> viterator = vendorItems.iterator();

while(viterator.hasNext()) {

String selected = ""; 
VendorItem vendor = viterator.next();

if(vendor.isSelected()) {
    selected = "Selected";
}