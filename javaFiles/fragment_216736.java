System.out.println("Is element number 1 expanded: " + panelsAndWellsPage.checkIfElementIsExpanded(1));
panelsAndWellsPage.collapseAnItem(1);
System.out.println("Is element number 1 expanded: " + panelsAndWellsPage.checkIfElementIsExpanded(1));

System.out.println("Is element number 3 expanded: " + panelsAndWellsPage.checkIfElementIsExpanded(3));
panelsAndWellsPage.expandAnItem(3);
System.out.println("Is element number 3 expanded: " + panelsAndWellsPage.checkIfElementIsExpanded(3));