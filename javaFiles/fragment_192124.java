String s = "testing data";
 if(!(this.element==null)){
        ListIterator<ElementData> li = this.element.listIterator();
        while (li.hasNext()) {
            ElementData ed = li.next();
            String temp = ed.getElemType().toString();
            System.out.println(temp);
            if (temp.equalsIgnoreCase("group")){
                 return ed.getGrpResult ();
            }
        }

 }
 return null;