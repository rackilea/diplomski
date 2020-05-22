int i = 0;
    Iterator<GuiInterface > it = components.iterator();
    while (it.hasNext()) {
        i++;
        GuiInterface  thisComp = it.next (); 
        if (thisComp.getName().equals(component.getName())) {
          if(i > 0 && components.get(i- 1) == null){  // this code does not make sense
            return false;
          }
        }

    }