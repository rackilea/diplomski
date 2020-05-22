Iterator<Pair> pairIt = pairs.iterator();
String first = "";
String second = "";

while(pairIt.hasNext()) {
    Pair current = pairIt.next();

    first += "| " + current.getProcessState() + " |";
    second += "  " + current.getTime() + "  ";

    if(pairIt.hasNext()) {
        first += " ====== ";
        second += "        ";
    }
}

RoundRobin.ps.printf(first);
RoundRobin.ps.printf(second);