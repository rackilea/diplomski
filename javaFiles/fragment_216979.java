@ModelAttribute("order")
public Order getOrderTypeFromRequest(final HttpServletRequest request, final Model model)
{
    try
    {
        String orderType = request.getParameter("type");
        switch (orderType)
        {
            case "PRNOrder" : return new PRNOrder();
            case "frequencyScheduledOrder" : return new FrequencyScheduledOrder();
        }
    }
    catch (Exception ex)
    {
        return null;
    }
    return null;
}