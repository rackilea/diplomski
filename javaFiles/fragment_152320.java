while((line = buffer.readLine()) !=null) {
    counter++;
    if (counter == 3) {
        //String[]word = Ingredient.split(",");
        String[]word = line.split(",");

        int Quantity = Integer.parseInt(word[1]);
        //int ServingNumberInt = Integer.parseInt();
        int Multiplier = NewServingNumber / Quantity;
        int NewQuantity = (Multiplier * NewServingNumber);

        System.out.println("Your new quantity is " + NewQuantity);   
    }

}