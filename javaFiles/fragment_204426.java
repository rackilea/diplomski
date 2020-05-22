switch(operation) {
    case "+" : { result = add; break; }
    case "-" : { result = sub; break; }
    case "*" : { result = mul; break; }
    case "/" : { result = div; break; }
    case "%" : { result = per; break; }
    default : { System.out.println("Invalid operator!"); break; }
}