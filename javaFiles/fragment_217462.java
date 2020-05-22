for (int i = 0; i < data.numAttributes(); i++)
{
    // Print the current attribute.
    System.out.print(data.attribute(i).name() + ": ");

    // Print the values associated with the current attribute.
    double[] values = data.attributeToDoubleArray(i);
    System.out.println(Arrays.toString(values));
}