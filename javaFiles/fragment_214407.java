System.out.print("Unit Cost:\t");

if (Input.hasNextDouble())
{
    Money = Input.nextDouble();

    // you can now set your object
    // ...
}
// it's not a double; look for "stop"
else if (Input.nextLine().equalsIgnoreCase("stop"))
{
    // exit loop
    break;
}

// NOTE: if it's NOT a double or stop, then you have NOT exited
//       and you have not set money