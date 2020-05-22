static void Main(string[] args)
{
    CalculatorServiceClient proxy = new CalculatorServiceClient();
    int result = proxy.Add(2, 3);
    Console.WriteLine("Calculator Service returned: " + result.ToString());
}