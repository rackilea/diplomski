while (inputStream.hasNextLine())
{
    String line = inputStream.nextLine(); //reads next line
    String[] array2 = line.split(",");
    System.out.println(array2[0]);

    //if (array2[0].isEmpty())
    //   outputStream.printf("%12s  %24s", array2[0], array2[1]);
    //  
    //else
    //{   
    //    
    //    double quantity = Double.parseDouble(array2[0]);
    //    quantity = (quantity * caloricMultiplier);
    //    outputStream.printf("%12s  %24s", quantity, array2[1]);
    //}
}