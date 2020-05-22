ActiveXComponent outlookApplication = new ActiveXComponent("Outlook.Application");
Dispatch namespace = outlookApplication.getProperty("Session").toDispatch();

Dispatch contactsFolder = Dispatch.call(namespace, "GetDefaultFolder", new Integer(10)).toDispatch();
Dispatch contactItems = Dispatch.get(contactsFolder, "items");
String filter = String.format("[Email1Address] = '%s'", cont.getPrimaryEmail());
Dispatch contact = Dispatch.call(contactItems, "find", filter);

if (contact != null)
{
    Dispatch.call(contactItem, "Delete");
}