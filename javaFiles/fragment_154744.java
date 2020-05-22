import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

class LambdaInvoker {

    public void runWithoutPayload(String region, String functionName) {
        runWithPayload(region, functionName, null);
    }

    public void runWithPayload(String region, String functionName, String payload) {
        AWSLambdaAsyncClient client = new AWSLambdaAsyncClient();
        client.withRegion(Regions.fromName(region));

        InvokeRequest request = new InvokeRequest();
        request.withFunctionName(functionName).withPayload(payload);
        InvokeResult invoke = client.invoke(request);
        System.out.println("Result invoking " + functionName + ": " + invoke);
    }
}