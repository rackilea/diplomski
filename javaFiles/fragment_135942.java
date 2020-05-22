// Add Font
PDResources resources = form.getDefaultResources();
if(resources == null)
{
    resources = new PDResources();
}
resources.put(COSName.getPDFName("Helvetica"), PDType1Font.HELVETICA);
if(form.getDefaultResources() == null)
{
    form.setDefaultResources(resources);
}
// End Add Font