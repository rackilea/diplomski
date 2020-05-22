//Create a new contact first
Entity contact = new Entity("contact");
contact["lastname"] = "Wood";

Guid contactId = service.Create(contact);

//Create an incident/case which links to that new contact
Entity incident = new Entity("incident");
incident["customerid"] = new EntityReference("contact", contactId)
service.Create(incident)