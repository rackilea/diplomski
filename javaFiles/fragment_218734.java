NodeList applicationIDNodes = getElementsByTagName("ApplicationID");
for (int i = 0; i < applicationIDNodes.length; i++) {
   Node applicationIDNode = applciationIdNodes.getItem(i);
   NodeList applicationIdChildren = applicationIdNode.getChildren();

   String vendorId = applicationIdChildren.getItem(0).getAttribute("value").value();
   String authAppliId = applicationIdChildren.getItem(1).getAttribute("value").value();
   String actApplID = applicationIdChildren.getItem(2).getAttribute("value").value();

   // do whathever you want with vendorId, authAppliId, actApplID       
}