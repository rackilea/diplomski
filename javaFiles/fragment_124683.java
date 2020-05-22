String tmp = scanner.next();

if(!tmp.length()<=1)
{
letters[addr(tmp.charAt(0))] = Integer.parseInt(tmp.substring(2,tmp.length()))\
}

else
{
    //do something to handle ArrayOutOfBondsException
}