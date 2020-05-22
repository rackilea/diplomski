List<Item> itemsList; // this list is populated before accessing
List<SelectedItem> selectedItemsList;

...
       dialogBuilder.setMultiChoiceItems(playlists, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        selectedItemsList.add(itemsList.get(which).getSelectedItem());

                    } else if (selectedItemsList.get(which) != null) {
                        selectedPlaylists.remove(itemsList.get(which).getSelectedItem());
                    }

                }
        });