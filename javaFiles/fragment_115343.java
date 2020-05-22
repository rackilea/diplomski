@Override
public Component getBean(OgnlValueStack stack, HttpServletRequest request, HttpServletResponse response)
{
    Pagination pagination = new Pagination(stack, request, response);
    pagination.setList(list);
    return pagination;
}