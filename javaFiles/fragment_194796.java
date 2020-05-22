for (int i = 0; i < liste.size(); i++) {
//                  if (k.getName().equalsIgnoreCase(liste.get(i).getName())
//                          && k.getSurname().equalsIgnoreCase(liste.get(i).getSurname())) {
//                      liste.remove(i);
//              }
                    if(k.equals(liste.get(i))) {
                        liste.remove(i);

                    }
                }