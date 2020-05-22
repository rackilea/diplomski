try
{
    sheet.createFreezePane(0,0);
}
catch(IndexOutOfBoundsException e)
{
    System.out.println("previously didn't have a freeze pane.");
}