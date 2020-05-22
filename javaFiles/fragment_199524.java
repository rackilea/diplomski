// Names of the elements to remove if empty
Set<String> removable = ....

// Parse the html into a jsoup document
Document source = Jsoup.parse(myHtml);

// Clean the html according to a whitelist
Document cleaned = new Cleaner(whitelist).clean(source);

// For each element in the cleaned document
for(Element el: cleaned.getAllElements()) {

   if(el.children().isEmpty() && !el.hasText()) {
       // Element is empty, check if should be removed
       if(removable.contains(el.tagName())) el.remove();
   }
}