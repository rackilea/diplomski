//get the application module
    DCBindingContainer dcbindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    AppModule am = (AppModule)dcbindings.getDataControl().getApplicationModule();

    //Run the filtering logic
    am.nameOfYourMethod(PassSomeData,BlahBlah);