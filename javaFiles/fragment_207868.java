ArrayList<HashMap<String, Object>> kids = new ArrayList<HashMap<String, Object>>();
HashMap<String, Object> link1 = new HashMap<String, Object>();
link1.put("Title", "link1");
link1.put("Action", "GoTo");
link1.put("Page", String.format("%d Fit", page));
kids.add(link1);
helloworld.put("Kids", kids);