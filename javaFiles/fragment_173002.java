switch(test) {
    case '1':
        System.out.println("This is printed by case '1'");
    case '0':
        System.out.println("This is printed by both case '1' and case '0'");
        break;
    case 'x':
    case 'X':
        System.out.println("This is only printed by the Xs");
        break;
    default:
        break;
}