public void addRecords(String Package, String ClassName, String[] ListOfBoxes)
{
    format.format("%s", "package " + Package + ";"\n");
    format.format("%s", "@SideOnly(Side.CLIENT)\n");
    format.format("%s", "public class " + ClassName + " extends ModelBiped\n");
    format.format("%s", "{\n");
    for (String box : listOfBoxes)
    {
        format.format("%s", "    ModelRenderer " + box + ";\n");
    }
    format.format("%s", "}\n");

}