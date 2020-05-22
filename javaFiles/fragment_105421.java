public void logDetails(){
    Iterator<IvsBerichtPojo> it = ivsBerichtReader.iterator();
    while(it.hasNext()) {
        IvsBerichtPojo bericht = it.next();
        logger.info(bericht.getScheepsNummer()); 
    }
}