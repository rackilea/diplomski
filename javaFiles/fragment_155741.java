if (command.getName().equalsIgnoreCase("ukey")){
    String Private_uKEY = uKEY(7);
    if(LANG == 1){
        player.sendMessage(ChatColor.RED + "Twoj unikalny kod to: "+ ChatColor.YELLOW + Private_uKEY);
        player.sendMessage(ChatColor.RED + "Podany kod wpisz na stronie "+ ChatColor.YELLOW + "www.crafme.net");        
        return true; //Returning a value
    } else {
        player.sendMessage(ChatColor.RED + "Your unique code is: "+ ChatColor.YELLOW + Private_uKEY);
        player.sendMessage(ChatColor.RED + "Enter the code on the page "+ ChatColor.YELLOW + "www.crafme.net");
        return true; //Returning a value on the else too
    }
    //Since both the if and the else return something, the code below won't be executed.
    sql.uKEY(Private_uKEY, player.getName()); 

}

return false;