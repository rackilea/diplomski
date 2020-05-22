private static void hackilySetColor(JSpinner spinner, Color color)
{
    int n = spinner.getComponentCount();
    for (int i=0; i<n; i++)
    {
        Component c = spinner.getComponent(i);
        if (c instanceof BasicArrowButton)
        {
            try
            {
                Field field = BasicArrowButton.class.getDeclaredField("darkShadow");
                field.setAccessible(true);
                field.set(c, color);
                field.setAccessible(false);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}