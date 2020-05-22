while (it.hasNext()) {

    //Get link and create object
    Object [] record = it.next();
    String identityName = (String) record[0];
    Identity user = (Identity) context.getObject(Identity.class, identityName);

    //Get Identity attributes for export
    String workforceid = (String) user.getAttribute("workforceID");

    //Get application attributes for export
    String userid="";

    List links = user.getLinks();
    if (links!=null)
    {
        Iterator lit = links.iterator();
        while (lit.hasNext())
        {
            Link l = lit.next();
            String lname = l.getApplicationName();
            if (lname.equalsIgnoreCase(appname))
            {
                userid = (String) l.getAttribute("User Name");
                List orgList = l.getAttribute("Organization");
                if(organization &lt; orgList.size()) {
                    String singleOrganization = orgList.get(organization);
                    organization++;


                    //Output file
                    out.write(identityName+","+userid+","+workforceid+","+orgList);
                    out.newLine();
                    out.flush();

                }

            }
        }
    }