List links = user.getLinks();
    if (links != null) {
        Iterator lit = links.iterator();
        while (lit.hasNext()) {
            Link l = lit.next();
            String lname = l.getApplicationName();
            if (lname.equalsIgnoreCase(appname)) {
                userid = (String) l.getAttribute("User Name");
                List organizations = l.getAttribute("Organization");

                StringBuilder sb = new StringBuilder();
                String listItemsSeparator = " "; // this you can change to anything you want, it separates items from list

                //iterating over list, to convert it to single String 
                for (Object organization : organizations) {
                    sb.append(organization.toString());
                    sb.append(listItemsSeparator);
                }

                orgList = sb.toString().trim();

            }
        }
    }