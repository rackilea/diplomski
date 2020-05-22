public static void updateCats(List<Cat> catsFromServer) {
            setAllCatsLegs(catsFromServer);
            List<Cat> currentCats = getAllCats();
            for (Cat currentCat : currentCats) {
                for (Cat fromServer : catFromServer) {
                    if (currentCat.equals(fromServer)) {
                        fromServer.setHeads(currentcat.getHeads());
                    }
                }
            }
            Contact.saveMultiple(contactsFromServer);
        }