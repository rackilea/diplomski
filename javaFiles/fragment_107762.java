enum TriggerHandlerType {
    DASHBOARD {
        @Override
        TriggerHandler create() {
            return new DashboardTriggerHandler();
        }
    },
    COMPONENT_HANDLER {
        //...
    };

    abstract TriggerHandler create();
}