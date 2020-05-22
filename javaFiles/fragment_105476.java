public CustomClass getindexedListobj(int index) {
     CustomClass tmp = null;
     for(CustomClass o : this.listobj)
        if(o.getId() == index) {
          tmp = o;
          break;
        }
     if(tmp == null) {
       tmp = new CustomClass();
       this.listobj.add(tmp);
     }
   return tmp;
}