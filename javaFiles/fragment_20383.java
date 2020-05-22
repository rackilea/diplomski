for(int f=0;f<dayOfTicket.length;f++){
    if(dayOfTicket[f]>mostWantedDay){
        indexOfWantedDay=f+1;
        mostWantedDay = dayOfTicket[f];
    }
    if(dayOfTicket[f]<LessWantedDay && dayOfTicket[f] > 0){
        indexOfLessWantedDay=f+1;
        LessWantedDay = dayOfTicket[f]
    }
}