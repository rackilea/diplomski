Elements result = third.select("span.icon-list__title");
if (result.size() > 0) {
    title_software = result.get(0).toString();
}
if (result.size() > 1) {
    photo_time = result.get(1).toString();
}
System.out.println(title_software);
System.out.println(photo_time);