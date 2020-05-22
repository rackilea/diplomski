String line = scan.nextLine(); // read from Scanner **once** only
if (line.equals("yes")) {
    skan.reset();
    starGiver();
} else if (line.equals("no")) {
    wishMaker();
} else {