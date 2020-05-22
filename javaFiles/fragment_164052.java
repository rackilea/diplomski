final List<RewardAndPenaltiesThroughSoftConstraints> contribs = new ArrayList<RewardAndPenaltiesThroughSoftConstraints>();
        for (Integer id : forcedOrdersList.keySet()) {
            List<String> order= forcedOrdersList.get(id);
            String before = order.get(0);
            String after = order.get(1);
            constraintManager.addConstraint(new OneJobBeforeAnother(stateManager, before, after));
            contribs.add(new RewardAndPenaltiesThroughSoftConstraints(problem, before, after));
        }

        SolutionCostCalculator costCalculator = new SolutionCostCalculator() {

            @Override
            public double getCosts(VehicleRoutingProblemSolution solution) {
                double costs = 0.;
                List<VehicleRoute> routes = (List<VehicleRoute>) solution.getRoutes();
                for(VehicleRoute route : routes){
                    costs+=route.getVehicle().getType().getVehicleCostParams().fix;
                    costs+=stateManager.getRouteState(route, InternalStates.COSTS, Double.class);
                    for (RewardAndPenaltiesThroughSoftConstraints contrib : contribs) {
                        costs+=contrib.getCosts(route);
                    }
                }
                return costs;
            }

        };