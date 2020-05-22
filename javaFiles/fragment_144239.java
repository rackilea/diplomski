System.out.println("Enter the car registration number of the type \"A1234\" ");
    input = scanner.nextLine();
    if(input.matches("[A-Z][0-9]{4}"))
    {
            if (!carParkObj.contains(input))//if the regno is not already present
            {
             .......

}