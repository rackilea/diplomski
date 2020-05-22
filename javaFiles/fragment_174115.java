deleteButton.addEventListener(Events.ON_CLICK,
            new EventListener() {
        public void onEvent(Event evt) {
            List<Component> toRemove = new Vector<Component>();
            Iterator<Component> selected = randomTable.queryAll("row checkbox").iterator();
            System.out.println("Deleted: ");
            while (selected.hasNext()) {
                Checkbox c = (Checkbox) selected.next();
                if (c.isChecked()) {
                    System.out.print(c.getId()); 
                    System.out.println(" from row " + c.getParent().getId());
                    toRemove.add(c.getParent());
                }
            }
            for (Component c : toRemove)
                c.detach();
        }

    });