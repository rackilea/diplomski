List<ContactPOJO> list_contact;
List<ContactPOJO> list_selected_contact = new ArrayList();
for (ContactPOJO pojo : list_contact){
    pojo.setIs_selected(true);
    list_selected_contact.add(pojo);
}