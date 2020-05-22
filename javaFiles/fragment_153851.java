final String X = "00";
final String Z = "ff";
final String Y = "10";

if(Integer.parseInt(X, 16) <= Integer.parseInt(Y, 16) && Integer.parseInt(Y, 16) <= Integer.parseInt(Z, 16)) {
    System.out.println("X <= Y <= Z");
}