class MoveHandler implements DropHandler
{
    private static final long       serialVersionUID    = -5709370299130660699L;
    private AbstractOrderedLayout   layout;
    private Level                   level;

    public MoveHandler(AbstractOrderedLayout layout, Level level)
    {
        this.layout = layout;
        this.level = level;
    }

    public AcceptCriterion getAcceptCriterion()
    {
        return AcceptAll.get();
    }

    @SuppressWarnings("deprecation")
    public void drop(DragAndDropEvent dropEvent)
    {
        Transferable transferable = dropEvent.getTransferable();
        Component sourceComponent = transferable.getSourceComponent();
        TargetDetails dropTargetData = dropEvent.getTargetDetails();
        DropTarget target = dropTargetData.getTarget();

        // First question cann't be dragged.
        if (layout.getComponent(0).equals(sourceComponent))
            return;

        // find the location of the dragged component
        Iterator<Component> componentIterator = layout.getComponentIterator();
        Component next = null;
        int indexSourceComponent = 0;
        while (componentIterator.hasNext())
        {
            next = componentIterator.next();
            if (next == sourceComponent)
                break;
            indexSourceComponent++;
        }

        // find the location where to move the dragged component
        boolean sourceWasAfterTarget = true;
        int index = 0;
        componentIterator = layout.getComponentIterator();
        next = null;

        while (next != target && componentIterator.hasNext())
        {
            next = componentIterator.next();

            if (next != sourceComponent)
            {
                index++;
            }
            else
            {
                sourceWasAfterTarget = false;
            }
        }
        if (next == null || next != target)
        {
            // component not found - if dragging from another layout
            return;
        }

        // drop on top of target?
        if (dropTargetData.getData("verticalLocation").equals(VerticalDropLocation.MIDDLE.toString()))
        {
            if (sourceWasAfterTarget)
            {
                index--;
            }
        }

        // drop before the target?
        else if (dropTargetData.getData("verticalLocation").equals(VerticalDropLocation.TOP.toString()))
        {
            index--;
            if (index < 0)
            {
                index = 0;
            }
        }

        // Nothing can be dragged to 1st position. 1st positions is secured for default question.
        if (index == 0)
            return;

        // move component within the layout
        layout.removeComponent(sourceComponent);
        layout.addComponent(sourceComponent, index);

    }
}