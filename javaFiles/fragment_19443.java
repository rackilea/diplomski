val steam = try { 
    Steam() 
} catch(e: SteamNotFoundException) { 
    val path = // ask user to enter path somehow 
    Steam(path)
}