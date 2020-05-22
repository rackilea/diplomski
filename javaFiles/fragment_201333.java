void testNullArgument()
{
    shouldFail(IllegalArgumentException)
    {
        archiveUtility.process(lstFileName, "", workflowId)
    }

}