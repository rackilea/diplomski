// Fetch the list feed of the worksheet.
ListQuery listQuery = new ListQuery(listFeedLink.HRef.ToString());
ListFeed listFeed = service.Query(listQuery);

// Create a local representation of the new row.
ListEntry row = new ListEntry();
row.Elements.Add(new ListEntry.Custom() { LocalName = "firstname", Value = "Joe" });
row.Elements.Add(new ListEntry.Custom() { LocalName = "lastname", Value = "Smith" });
row.Elements.Add(new ListEntry.Custom() { LocalName = "age", Value = "26" });
row.Elements.Add(new ListEntry.Custom() { LocalName = "height", Value = "176" });

// Send the new row to the API for insertion.
service.Insert(listFeed, row);