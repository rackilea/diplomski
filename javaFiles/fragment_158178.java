int words = 0;
for (int I = 0; I<response1.length; I++) {
    if (response[I].equalsIgnoreCase("hi") || response[I].equalsIgnoreCase("how") || response[I].equalsIgnoreCase("you"))
        words++;
}

if (words == 3)
    System.out.println("It works");