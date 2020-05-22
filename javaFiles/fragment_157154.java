String text = "";
int counter = 0;
for(int i = 0; i < CardsPC.size(); i++){
     text = text + (i > 0 ? ", " : "") + CardsPC.get(i);
     if (CardsPC.get(i).contains("A")) { // or use equals, base on your input.
          counter++;
          // do something with found "A" element if you want.
     }
}