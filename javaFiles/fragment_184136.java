PropertySet psPropSet = new PropertySet(BasePropertySet.FirstClassProperties);
        NameResolutionCollection coll = service.ResolveName("glen", ResolveNameSearchLocation.DirectoryOnly,true , psPropSet);
        foreach (NameResolution nameRes in coll)
        {
            Console.WriteLine("Contact name: " + nameRes.Contact.Alias);
        }