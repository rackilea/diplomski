if (null != attribs)
        {
            for (NamingEnumeration ae = attribs.getAll(); ae.hasMoreElements();)
            {

                Attribute atr = (Attribute) ae.next();
                for (
                    Enumeration vals = atr.getAll(); 
                    vals.hasMoreElements(); 
                ) {
                        list.add(vals.nextElement().toString());
                }
            }
        }