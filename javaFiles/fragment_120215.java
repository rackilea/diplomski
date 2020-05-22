public String[] getOption(){
    String line = new Scanner(System.in).nextLine();
    return line.split(" ");
}

...

String[] inputs = getOption();

...

case "add": dataMap.put(inputs[1], getValues(inputs));
....