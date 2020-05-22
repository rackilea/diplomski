List<Element> keepList = new ArrayList<>();
Elements els = doc.select(".cellRight");
for (Element el : els){
  boolean keep = true;
  for (Element parentEl : el.parents()){
     if (parentEl.hasClass("cellRight")){
        //parent has class as well -> discard!
        keep = false;
        break;
     }
  }
  if (keep){
    keepList.add(el);
  }
}
//keepList now contains inner most elements with your class