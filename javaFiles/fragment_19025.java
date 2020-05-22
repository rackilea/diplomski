do {
            PlantListitems plantListItems = new PlantListitems();


            plantListItems.setName(c1.getString(c1
                    .getColumnIndex("name")));

            //Add the plantListItem object to the ContactList arrayList.
            contactList.add(plantList);




        } while (c1.moveToNext());