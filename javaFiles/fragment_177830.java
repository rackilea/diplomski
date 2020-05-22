Scanner s = new Scanner(tagFile);
while(s.hasNextLine()) {
    String info = s.nextLine();
    if (info.startsWith("HP") {
        int hp = Integer.parseInt(info.substring(info.indexOf("=" + 1),info.length()));
        p.setHP(hp);
    }
    else if (...) //Etc... for all the other values
}