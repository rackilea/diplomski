ListBox listBox = new ListBox();
            //add some entries to the listbox
            int itemCount = listbox.getItemCount();

            for (int i = itemCount - 1; i >= 0; i--) {

                if ("YOURTEXT".equals(listbox.getItemText(i))) {
                    statusListBox.removeItem(i);
                }
            }