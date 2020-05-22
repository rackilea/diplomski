List<MMenuElement> children = menu.getChildren();

boolean gotExisting = false;

for (MMenuElement child : children)
 {
   if ("Another Exit".equals(child.getLabel())
    {
      gotExisting = true;
      break;
    }
 }

if (!gotExisting)
 {
   ... add to menu
 }