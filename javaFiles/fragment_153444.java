act.get(i).setProjectDescriptionList(NewsletterUtil.convertParagraphs(ttextt));
obj.put("ProjectDescriptionList" ,act.get(i).getProjectDescriptionList() );
obj.put("currentStatus", act.get(i).getCurrentStatus());
obj.put("area", act.get(i).getArea());
// I don't know why you wrote it twice.. I'm commenting it.
//   obj.put("ProjectDescriptionList" , act.get(i).setProjectDescriptionList(NewsletterUtil.convertParagraphs(ttextt)));
jsonarray.put(obj);