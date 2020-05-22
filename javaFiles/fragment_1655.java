StringBuilder phone = new StringBuilder();
for (int i = 0; i < number.length(); i++){
    if (Character.isLetter(number.charAt(i))){
        phone.append(getNumber(Character.toUpperCase(number.charAt(i))));
    }else{
        phone.append(number.charAt(i));
    }
}

System.out.println("Your number is " + phone.toString());