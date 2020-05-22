private static int requestCount = 0;

....

int localCount = requestCount;
requestCount++;
if (localCount % 2 == 0) {
{
    return "PROXY 10.10.10.1:8080; " + "PROXY 10.10.10.2:8080";
}
else
{
    return "PROXY 10.10.10.2:8080; " + "PROXY 10.10.10.1:8080";
}