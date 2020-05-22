String switchVar = "a";
final String matchZero = "a";
switch (switchVar) {
    case matchZero: // valid since there's no way matchZero can ever be mutated
        System.out.println("Matches");
        break;
    default:
        System.out.println("No Match");
        break;
}