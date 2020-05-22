SelectedItemConverter select=new SelectedItemConverter();

       for (Activity li : (Set<Activity>)select.coerceToBean(selectedUserAcc, getListGent()))
                        {
                            al.add(li);
                        }


                        List<Activity> act=al;