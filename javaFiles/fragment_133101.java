public enum EnvironmentIds {

USER_MANAGER_CHANGED("e29e902c","28a6e01c", "281916f6"),
USER_ADDED_TO_GROUP("5059020b", "f039fc37", "0e480029"),
USER_CREATED("d9bc6a0c", "f26f0a23", "9261f53a"),
USER_REMOVED_FROM_GROUP("fc30b97c", "15528295", "c08af3b2");


String holdingId;
String productionId;
String stagingId;

EnvironmentIds(String holdingId, String stagingId, String productionId) {
    this.holdingId = holdingId;
    this.stagingId = stagingId;
    this.productionId = productionId;
}

public String getId(String environment) {
    switch(environment) {
        case "holding":
            return getHoldingId();
        case "production":
            return getProductionId();
        case "staging":
            return getStagingId();
        default:
            return null;
    }
}
public String getHoldingId() {return holdingId;}

public String getProductionId() {return productionId;}

public String getStagingId() {return stagingId;}
}