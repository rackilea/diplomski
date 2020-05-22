Iterator<Child> i = form.getDeleteItems().iterator();
while(i.hasNext()){
    Child child = i.next();
    for (Iterator<Child> it = parent.getChildren().iterator();) {
         if (child.getId().equals(it.next().getId()) {
             it.remove(); // this removes the child from the underlying collection
         }
    }
}