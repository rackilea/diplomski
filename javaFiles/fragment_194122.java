if (inputString.equals("quit")) {
    System.out.println("You have quit");
} else {
    FirstArray[i] = inputArray[0];
    SecondArray[i] = Integer.parseInt(inputArray[1]);  // these throw errors
    ThirdArray[i] = Integer.parseInt(inputArray[2]);    

    System.out.println(FirstArray[i]);
    System.out.println(SecondArray[i]);
    System.out.println(ThirdArray[i]);
}