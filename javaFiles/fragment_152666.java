@Override
protected void setOptionAttributes(AppendingStringBuffer buffer, E choice, int index, String selected)
    {
        super.setOptionAttributes(buffer, choice, index, selected);
        buffer.append("role=\"menuitem\" ");
     ...