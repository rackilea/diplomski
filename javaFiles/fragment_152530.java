MenuElement[] topLevelElements = frameApp.getJMenuBar().getSubElements();
            //Get top level elements--> FileMenu etc
            for(MenuElement menuElement: topLevelElements)
            {
                MenuElement[] subElements = menuElement.getSubElements();
                //get the child elements which are of type JPopupMenu
                for(MenuElement subElement:subElements)
                {
                     //This is the popuMenu which contains child elements
                    System.out.println(subElement.toString());
                    if(subElement instanceof JPopupMenu)
                    {
                        //show child elements
                        for(MenuElement childMenuItem:subElement.getSubElements())
                        {
                            //New and Save here ...
                            System.out.println("ChildMenu Name=>" + childMenuItem.getComponent().getName());
                        }
                    }
                    else
                    {
                        //display names directly
                    }
                }
            }