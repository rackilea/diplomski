hasLower = false;
for(int i = 0; i < password.length(); i++){
      if(Character.isLowerCase(password.charAt(i))){
            hasLower = true;
            break; // Exits the last-entered loop.
    }
}