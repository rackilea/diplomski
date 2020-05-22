int index = 0;
for (; index < carLot.getCar().size(); index++) {
    System.out.printf("%-7s%-6s%-2s%-5s\n",
        index,
        carLot.getCar().get(index).getID(),
        carLot.getCar().get(index).getMake() + " " + carLot.getCar().get(index).getModel(),
        carLot.getCar().get(index).getPrice());
}
System.out.printf("%-7s%-6s", index, "Exit");