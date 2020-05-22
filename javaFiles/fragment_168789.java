private static Double calculate_average( ArrayList<Double> myArr )
{
    Double Sum = 0.0;
    for (Double number: myArr)
    {
        Sum += number;
    }

    return Sum / myArr.size();
}