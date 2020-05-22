public Component[] getObjects()
{
    return new Component[]{styleLB,redLB,redTF,greenLB,greenTF,blueLB,blueTF,yellowLB,yellowTF,totalLB,totalTF};
}
public void addAllToPanel(JPanel p)
{
    Component[] arr = getObjects();
    for(Component c:arr)
        p.add(c);
}