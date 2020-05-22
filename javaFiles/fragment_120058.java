Elements divs = doc.select("div.sports_FfCell"); //gets the div part that has the information you want. 

for (Element div : divs) {      
     if (div.toString().contains("market")) //there is a market tag for the table labels (sports_FfCell market).
        System.out.print(div.text() + " - "); //no new line after the winner text.
     else
        System.out.println(div.text().replace("MULTI", "- ")); //it gets the MULTI part too, so i replace it.
}