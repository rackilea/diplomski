public void getFilterStrings(List baseList, E element) {
       JComboBox cbo = view.getCboSearch();
       int selIndex = cbo.getSelectedIndex();
       Person p = (Person) element;

       if(selIndex == 0)
          baseList.add(p.getFirstName());
       else if(selIndex == 1)
          baseList.add(p.getLastName());
       else if(selIndex == 2)
          baseList.add(p.getBirthDay());
       else if(selIndex == 3)
          baseList.add(p.getAge());
       else if(selIndex == 4)
          baseList.add(p.getOccupation());
    }