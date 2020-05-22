new MockUp<TaskSASCustomerReading>()
    {
        @Mock
        // This original method is invoking Collections.max(). 
        // Therefore, I just mocked this one, other methods are all original
        String findLatestSelectionDate(Collection customerTOs) {
           return "";
        }
    };

    new Expectations(){
        SASCustomerDataAssemblerBD assembleBd;
        CustomerTOs tos;         
        SelectionJobLogBD logBd;
        {
            try {
                SASCustomerDataAssemblerBD.getInstanceUsingEjbRef(); result = assembleBd;
                assembleBd.getData();  result = tos;
                SelectionJobLogBD.getInstanceUsingEjbRef();  result = logBd;                                
            }catch(Exception e){}
        }
    };

    new TaskSASCustomerReading().execute();