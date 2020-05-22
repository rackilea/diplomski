azure.webApps().listAsync()
            .subscribe(webApp -> {
                int capacity = webApp.manager().appServicePlans().getById(webApp.appServicePlanId()).capacity();
                System.out.println(webApp.name() + ": " + capacity + (capacity == 1 ? " instance" : " instances"));
            });
}