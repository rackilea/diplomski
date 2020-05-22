else if(tempEdgeStack_A.getSize()> 0)
    {
        while(tempEdgeStack_A.iterator().hasNext())
        {
            result.push(tempEdgeStack_A.iterator().next()); 
        }
    }
    else if(tempEdgeStack_B.getSize()> 0)
    {
        while(tempEdgeStack_B.iterator().hasNext())
        {
            result.push(tempEdgeStack_B.iterator().next()); 
        }
    }