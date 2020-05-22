// ...
RollingStock headPoint = getHeadPoint().orElse(yourDefaultRollingStock);
// or
RollingStock headPoint = getHeadPoint().orElseGet(aMethodGettingYourDefaultRollingStock());
// or
RollingStock headPoint = getHeadPoint().orElseThrow(() -> new Exception("The train is empty!"));
// or
getHeadPoint().ifPresent(headPoint -> doSomethingWithHeadPoint(headPoint));