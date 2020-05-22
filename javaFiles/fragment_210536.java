switch(option) {
    case 1:
        out.write(Integer.toString(a+b));
        System.out.println(a + b);
        break;            // <---- added a "break" for each case
    case 2:
        out.write(Integer.toString(a - b));
        break;
    case 3:
        out.write(Integer.toString(a * b));
        break;
    case 4:
        out.write(Double.toString(1.0 * a / b));
        break;
    default:
        System.out.println("Operations are: 1=add 2=subtract 3=multiply 4=divide");
        break;
}