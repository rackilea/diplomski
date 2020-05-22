Elements timeTags = doc.select("time");
Element timeLivestamp = null;
for(Element tag:timeTags){
  Element livestamp = tag.selectFirst(".livestamp");
  if(livestamp != null){
   timeLivestamp = livestamp;
   break;
   }

}