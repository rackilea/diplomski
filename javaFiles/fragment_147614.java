String allchar = 
"PJGOGROG fnkmslkjsfsdmnsgdnklnsgklsgknlgrf jkghijgdlkjkgjdfkjgf kjlgdfkjlfdgfjklklj
kljfdkjlfkjldfdkjslkljdfskjlfsjkldfsjklkljs
fdsjklsdfkljsfdkljkhgfhhgdfsgkhdfskghfdskghfdsghsfdghafevbhfsvgydcgubcdmgycdgfehkhfeghjgh68
Alias12345";

    StringBuilder number = new StringBuilder();
    String reqtext = allchar.replaceAll("\\s+","");
    for(int i = reqtext.length()-10; i < reqtext.length(); i++)
    {
        number.append(reqtext.charAt(i));
    }
    System.out.println(number.toString());