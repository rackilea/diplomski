while (more.equals("y"))
{
    ...

    // Add below codes
    num1 = 0 + xCoord;
    num2 = 5 + yCoord;
    num3 = 13 + xCoord;
    num4 = 10 + yCoord;

    System.out.println("ctx.moveTo(" + num1 + "," + num2 + ");"
        + "\nctx.lineTo(" + num3 + "," + num4 + ")\n"
        + "Mid Point: " + num3 + "," + num4);
    System.out.print("Again?: ");
    more = scan.next();
}