public class PrivateMemberPlugin
    extends Plugin
{

    @Override
    public String getOptionName()
    {
        return "Xpm";
    }

    @Override
    public String getUsage()
    {
        return "  -Xpm    : Change members visibility to private";
    }

    @Override
    public boolean run(Outline model, Options opt, ErrorHandler errorHandler)
        throws SAXException
    {
        for (ClassOutline co : model.getClasses())
        {

            JDefinedClass jdc = co.implClass;
            // avoid concurrent modification by copying the fields in a new list
            List<JFieldVar> fields = new ArrayList<JFieldVar>(jdc.fields().values());
            for (JFieldVar field : fields)
            {
                // never do something with serialVersionUID if it exists.
                if (!field.name().equalsIgnoreCase("serialVersionuid"))
                {
                    // only try to change members that are not private
                    if (field.mods().getValue() != JMod.PRIVATE)
                    {
                        // since there is no way to change the visibilty, remove the field an recreate it
                        jdc.removeField(field);
                        jdc.field(JMod.PRIVATE, field.type(), field.name());

                    }
                }
            }

        }
        return true;
    }

}