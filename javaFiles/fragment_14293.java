for (int i = 0; i < consonnant.length; i++) {
    if(tampon.endsWith(consonnant[i]+"S") && tampon.length()>3){
        tampon = tampon.replaceAll(consonnant[i]+"S",consonnant[i]+"");//supprime le "S" final s'il est situé après une consonne
    }
}
for (int i = 0; i < vowels.length; i++) {
    if( tampon.contains(vowels[i]+"S"+vowels[i])){
        tampon = tampon.replace("S"+vowels[i], "Z"+vowels[i]);//si le "S" précède une voyelle, remplacer par "Z" 
    }
}
return tampon;