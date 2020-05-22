//container
    container = (CustomizationManager)MBeanProxy.get(CustomizationManager.class, new ObjectName("portal:service=CustomizationManager"), MBeanServerLocator.locateJBoss());

    //transaction manager
    tm = (TransactionManager) new InitialContext().lookup("java:/TransactionManager");      

    tm.begin();

    //dashboard
    dashboard = container.getDashboard(new org.jboss.portal.identity.User() {

        public boolean validatePassword(String arg0) {
            return false;
        }

        public void updatePassword(String arg0) throws IdentityException {
        }

        public String getUserName() {
            return userId;
        }

        public Object getId() {
            return null;
        }
    });     
    System.out.println("!!! Portlal: " + dashboard.toString());

    //default page
    defaultPage = dashboard.getPage("default");
    System.out.println("!!! Page: " + defaultPage.toString());

    //gets page windows
    Collection<PortalObject> objects = defaultPage.getChildren();
    if (objects != null && objects.size() > 0) {
        for (PortalObject object : objects) {
            System.out.println("!!! PageChild: " + object.getName());
            System.out.println("!!! WindowRegion: " + object.getDeclaredProperty("theme.region"));

            String windowPortletName = object.getDeclaredProperty("portletName");

            if (StringUtils.equals(object.getDeclaredProperty("theme.region"), "column1"))
            {
                column1Windows.add(object.getName());

                System.out.println("!!! Column1Window: " + object.getName());
                System.out.println("!!! Column1WindowPortletName: " + object.getDeclaredProperty("portletName"));

                //removes from portlets list if already exists
                Iterator iterator = portlets.iterator();
                while (iterator.hasNext())
                {
                    Portlet tempPortlet = (Portlet) iterator.next();
                    if (StringUtils.equals(tempPortlet.getSystemName(), windowPortletName))
                    {
                        iterator.remove();
                    }                       
                }
            }
            else if (StringUtils.equals(object.getDeclaredProperty("theme.region"), "column2"))
            {
                column2Windows.add(object.getName());
                System.out.println("!!! Column2Window: " + object.getName());

                //removes from portlets list if already exists
                Iterator iterator = portlets.iterator();
                while (iterator.hasNext())
                {
                    Portlet tempPortlet = (Portlet) iterator.next();
                    if (StringUtils.equals(tempPortlet.getSystemName(), windowPortletName))
                    {
                        iterator.remove();
                    }                       
                }

            }
        }
    }

    tm.commit();