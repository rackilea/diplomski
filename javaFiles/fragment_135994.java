BigDay = new Date("November 14, 2013 14:50:55") 

function countdown(){ 
    gtoday = new Date();
    msPerDay = 24 * 60 * 60 * 1000;
    timeLeft = (BigDay.getTime() -gtoday.getTime());
    e_daysLeft = timeLeft / msPerDay;
    daysLeft = Math.max(0, Math.floor(e_daysLeft));
    e_hrsLeft = (e_daysLeft - daysLeft)*24;
    hrsLeft = Math.max(0, Math.floor(e_hrsLeft));
    e_minsLeft = Math.max(0, (e_hrsLeft -hrsLeft)*60);
    minsLeft = Math.floor(e_minsLeft);
    e_secsLeft = Math.max(0, (e_minsLeft - minsLeft)*60);
    secsLeft = Math.floor(e_secsLeft);

    document.getElementById('offer2').innerHTML = "<H4>" + daysLeft +
    ":Days " + hrsLeft +":Hrs " + minsLeft + ":Mins " + secsLeft + ":Secs Left</H4> ";

    if(timeLeft <=0 ) {
        return;
    }
    setTimeout(function(){countdown()},1000); 
}
setTimeout(function(){countdown()},1000);