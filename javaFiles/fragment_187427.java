void PrintReport(string header, params int[] numbers)
{
    Console.WriteLine(header);
    foreach (int number in numbers)
        Console.WriteLine(number);
}